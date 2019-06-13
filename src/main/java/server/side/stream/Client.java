package server.side.stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import stream.Stream.RequestData;
import stream.Stream.ResponseData;
import stream.StreamServiceGrpc;
import stream.StreamServiceGrpc.StreamServiceBlockingStub;

public class Client {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		RequestData requestData = RequestData.newBuilder().setText("hello world").build();
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8883).usePlaintext(true).build();
		StreamServiceBlockingStub stub = StreamServiceGrpc.newBlockingStub(channel);

		Iterator<ResponseData> it = stub.serverSideStreamFun(requestData);
		long start = System.currentTimeMillis();
		while (it.hasNext()) {
			System.out.println(it.next().getText());
		}
		channel.shutdown();
		System.out.println(System.currentTimeMillis() - start + " MS");

	}
}
