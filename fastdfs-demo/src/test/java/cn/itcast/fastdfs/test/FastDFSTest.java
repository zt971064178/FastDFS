package cn.itcast.fastdfs.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.github.tobato.fastdfs.domain.GroupState;
import com.github.tobato.fastdfs.domain.StorageNode;
import com.github.tobato.fastdfs.domain.StorageNodeInfo;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;

import cn.itcast.fastdfs.FastDFSApplication;

/**
 * ClassName: FastDFSTest  
 * (单元测试FastDFS)
 * @author zhangtian  
 * @version
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FastDFSApplication.class)
public class FastDFSTest {
	
	@Autowired
	private TrackerClient trackerClient;
	@Autowired
	private AppendFileStorageClient generateStorageClient;
	
	@Test
	public void testClient() {
		// TrackerClient
		// GenerateStorageClient
		// FastFileStorageClient
		// AppendFileStorageClient
	}
	
	@Test
	public void testTrackerClient() {
		StorageNode node = trackerClient.getStoreStorage() ;
		System.out.println(JSONObject.toJSONString(node));
		System.out.println("==========================");
		node = trackerClient.getStoreStorage("group1") ;
		System.out.println(JSONObject.toJSONString(node));
		System.out.println("==========================");
		StorageNodeInfo nodeInfo = trackerClient.getFetchStorage("group1", "rBDIZVezxTyAVL4gAAIlDwqbw20488.jpg") ;
		System.out.println(JSONObject.toJSONString(nodeInfo));
		System.out.println("==========================");
		List<GroupState> groupStates = trackerClient.listGroups() ;
		System.out.println(JSONObject.toJSONString(groupStates));
		System.out.println("==========================");
	}
	
	@Test
	public void testGenerateStorageClient() throws FileNotFoundException {
		File f = new File("C:\\Users\\zhangtian\\Desktop\\sy_80219211654.jpg") ;
		FileInputStream inputStream = new FileInputStream(f) ;
		StorePath path = generateStorageClient.uploadFile("group1", inputStream, f.length(), ".jpg") ;
		System.out.println(JSONObject.toJSONString(path));
	}
	
}
