package automaticRating;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.hust.algorithm.canopy.Canopy;
import com.hust.algorithm.kmeans.KMeans;
import com.hust.convertor.TFIDFConvertor;
import com.hust.distance.CosDistance;
import com.hust.jss.automaticrating.utils.zipUtils;
import com.hust.jss.utils.Config;
import com.hust.segmentation.AnsjSegmentation;
import com.hust.utils.ClusterUtil;
import com.hust.utils.ExcelReader;
import com.hust.utils.VectorUtil;
import com.hust.utils.VectorUtils;

/**
 * 获取聚类实验学生提交的文件，
 * 计算得出学生的成绩
 * 并将成绩写入数据库
 * @author tankai
 *
 */
public class GetResultOfClusterExcel {
	//学生ID
	private String stuId;
	//作业ID
	private Integer taskId;
	//文件完整性基础得分
	private Integer basicScore = 60;
	//Canopy聚类分数
	private Integer canopyScore = 0;
	//KMeans聚类分数
	private Integer kmeansScore = 0;
	//学生作业存放路径
	private String basePath;
	//Canopy核心类
	private Canopy canopy;
	//KMeans核心类
	private KMeans kmeans ;
	
	//学生聚类结果的DB值
	private double stuDB = 0f;
	//助教KMeans聚类结果计算出来的参考DB值
	private double stdDB = 0f;
	
	public GetResultOfClusterExcel(String stuId, Integer taskId){
		this.stuId = stuId;
		this.taskId = taskId;
		this.basePath = Config.task + taskId + "\\" + stuId;
	}
	public int getScore(){
		
		return kmeansScore;
	}
	
	private void getBasicScore(){
		File dataExcel = new File(basePath + "\\" + "原始数据.xls");
		File cdemoZip = new File(basePath + "\\" + "Canopy.zip");
		File kdemoZip = new File(basePath + "\\" + "KMeans.zip");
		File canopyresultZip = new File(basePath + "\\" + "canopysresult.zip");
		File kmeansresultZip = new File(basePath + "\\" + "kmeansresult.zip");
		//原始数据文件是否上传
		if(dataExcel.exists()){
			List<String> dataList = ExcelReader.read(basePath + "\\" + "原始数据.xls",0);
			
//			ClusterUtil.showDatalist(dataList);
			//分词
			AnsjSegmentation ansj = new AnsjSegmentation();
			ansj.setWordList(dataList);
			ansj.segment();
			
			//得到分词后的List集合
			List<String[]> seglist = ansj.getSegList(); 
//			ClusterUtil.showSeglist(seglist);
			
			//向量转换
			TFIDFConvertor convertor = new TFIDFConvertor(seglist);
			List<double[]> vectors = convertor.getVector();
			
			canopy = new Canopy();
			canopy.setVectors(vectors);
			//进行Canopy聚类
			canopy.cluster();
			
			//初始化KMeans聚类参数 （K值--Canopy聚类的个数，向量集合，迭代次数）
			kmeans = new KMeans(10, vectors, 20);
			//进行KMeans聚类
			kmeans.cluster();
			//计算参考DB值
			stdDB = calculateDB(ClusterUtil.getClusters(kmeans.getResultIndex(), dataList));
		}else{
			basicScore--;
		}
		if(!cdemoZip.exists()){
			basicScore--;
		}
		if(!kdemoZip.exists()){
			basicScore--;
		}
		if(canopyresultZip.exists()){
			try {
				zipUtils.unzip(canopyresultZip,basePath + "\\" + "canopyresult");
				getCanopyScore(basePath + "\\" + "canopyresult");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			basicScore--;
		}	
		if(kmeansresultZip.exists()){
			try {
				zipUtils.unzip(kmeansresultZip,basePath + "\\" + "kmeansresult");
				getKmeansScore(basePath + "\\" + "kmeansresult");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			basicScore--;
		}	
		
	}
	/**
	 * 计算KMeans聚类效果得分
	 * @param path
	 */
	private void getKmeansScore(String path) {
		// 获取结果文件夹路径
		File kDir = new File(path);
		if(kDir != null && kDir.exists() && kDir.isDirectory()){
			File[] fList = kDir.listFiles();
			List<List<String>> clusterList = new ArrayList<>();
			for(File file : fList){
				List<String> l = ExcelReader.read(file.getAbsolutePath(),0);
				clusterList.add(l);
			}
			//计算学生聚类结果的DB值
			stuDB = calculateDB(clusterList);
		}
		
	}
	/**
	 * 计算Canopy聚类文件数得分
	 * @param path
	 */
	private void getCanopyScore(String path) {
		// 获取结果文件夹路径
		File cDir = new File(path);
		if(cDir != null && cDir.exists() && cDir.isDirectory()){
			int x = cDir.listFiles().length;
			if(Math.abs(x - canopy.getCanopy()) <= canopy.getCanopy() / 10){
				canopyScore += 20;
			}else if(Math.abs(x - canopy.getCanopy()) <= canopy.getCanopy() / 5){
				canopyScore += 10;
			}else if(Math.abs(x - canopy.getCanopy()) <= canopy.getCanopy() / 2){
				canopyScore += 5;
			}else{
				canopyScore += 2;
			}
		}
	}
	
	/**
	 * 计算聚类结果的DB值
	 * @param dataList 聚类后的文本集合
	 * @return
	 */
	private double calculateDB(List<List<String>> dataList){
		double db = 0f;
		//
		List<List<double[]>> vectors = new ArrayList<>();
		for(List<String> c : dataList){
			AnsjSegmentation ansj = new AnsjSegmentation();
			ansj.setWordList(c);
			ansj.segment();			
			//得到分词后的List集合
			List<String[]> seglist = ansj.getSegList(); 			
			//向量转换
			TFIDFConvertor convertor = new TFIDFConvertor(seglist);
			List<double[]> cvectors = convertor.getVector();
			vectors.add(cvectors);
		}
		
		for(int i = 0 ; i < vectors.size() ; i++){
			double maxdb = 0f;
			CosDistance Ci = new CosDistance(vectors.get(i));
			for(int j = i + 1 ; j < vectors.size() ; j++){
				CosDistance Cj = new CosDistance(vectors.get(j));
				double t = (Ci.getThreshold() + Cj.getThreshold()) / ();
			}
		}
		
		if(vectors == null || vectors.size() == 0){
			return 0f;
		}
		return db;
	}
	
	private double clusterDis(List<double[]> a , List<double[]> b){
		double[] ai={0f},bi={0f};
		for(double[] d : a){
			ai = VectorUtil.add(ai, d);
		}
		
	}
}
