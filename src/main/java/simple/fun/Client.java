package simple.fun;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import stream.Stream.RequestData;
import stream.Stream.ResponseData;
import stream.StreamServiceGrpc;
import stream.StreamServiceGrpc.StreamServiceBlockingStub;

public class Client {

	public static void main(String[] args) throws FileNotFoundException, IOException {	
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8883).usePlaintext(true).build();
		StreamServiceBlockingStub stub = StreamServiceGrpc.newBlockingStub(channel);
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			RequestData requestData = RequestData.newBuilder().setText("hello world").build();
			ResponseData responseData = stub.simpleFun(requestData);
			System.out.println(responseData.getText());
		}
		System.out.println(System.currentTimeMillis() - start + " MS");
		channel.shutdown();
	}
}
