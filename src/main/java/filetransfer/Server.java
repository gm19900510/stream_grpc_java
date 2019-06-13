package filetransfer;

import java.io.IOException;

import filetransfer.FileTransferServiceGrpc.FileTransferService;

public class Server {
	private static int port = 8883;
	private static io.grpc.Server server;

	public void run() {
		FileTransferService fileTransferService = new FileTransferServiceImpl();
		server = io.grpc.ServerBuilder.forPort(port)
				.addService(FileTransferServiceGrpc.bindService(fileTransferService)).build();
		try {
			server.start();
			System.out.println("Server start success on port:" + port);
			server.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.run();
	}
}
