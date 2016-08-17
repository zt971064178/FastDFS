package cn.itcast.fastdfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.github.tobato.fastdfs.FdfsClientConfig;

@SpringBootApplication
// 导入依赖组件
@Import(FdfsClientConfig.class)
public class FastDFSApplication {
	public static void main(String[] args) {
		SpringApplication.run(FastDFSApplication.class, args) ;
	}
}
