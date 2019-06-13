package two.way.stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import stream.Stream.RequestData;
import stream.Stream.ResponseData;
import stream.StreamServiceGrpc;
import stream.StreamServiceGrpc.StreamServiceBlockingStub;
import stream.StreamServiceGrpc.StreamServiceStub;

public class Client {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8883).usePlaintext(true).build();
		StreamServiceStub asyncStub = StreamServiceGrpc.newStub(channel);

		StreamObserver<ResponseData> responseData = new StreamObserver<ResponseData>() {
			@Override
			public void onNext(ResponseData value) {
				// TODO Auto-generated method stub
				System.out.println(value.getText());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				// 关闭channel
				channel.shutdown();
			}
		};

		StreamObserver<RequestData> requestData = asyncStub.twoWayStreamFun(responseData);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			requestData.onNext(RequestData.newBuilder().setText("你好" + i).build());
		}
		requestData.onCompleted();
		System.out.println(System.currentTimeMillis() - start + " MS");
		// 由于是异步获得结果，所以sleep 10秒
		Thread.sleep(10000);
	}
}
