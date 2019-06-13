package filetransfer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.google.protobuf.ByteString;

import filetransfer.FileTransferServiceGrpc.FileTransferService;
import filetransfer.Filetransfer.RequestData;
import filetransfer.Filetransfer.ResponseData;
import io.grpc.stub.StreamObserver;

public class FileTransferServiceImpl implements FileTransferService {

	// 将byte数组写入文件
	public void createFile(String filePath, byte[] content) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			fos.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String[] queryFileNames(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			return file.list();
		} else {
			return null;
		}
	}

	private byte[] getBytes(String filePath) {
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	@Override
	public void serverSideStreamFun(RequestData request, StreamObserver<ResponseData> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("请求参数：" + request.getText());
		long start = System.currentTimeMillis();
		String[] fileNames = queryFileNames("D://apache-tomcat-8.0.33//webapps//ROOT");

		for (int i = 0; i < 500; i++) {
			byte[] bytes = getBytes("D://apache-tomcat-8.0.33//webapps//ROOT//" + fileNames[i]);
			// createFile("1.jpg", bytes);
			responseObserver.onNext(ResponseData.newBuilder().setDeviceId("设备1")
					.setRequestId(UUID.randomUUID().toString()).setFileData(ByteString.copyFrom(bytes)).build());
		}
		System.out.println(System.currentTimeMillis() - start + " MS");
		responseObserver.onCompleted();
	}

}
