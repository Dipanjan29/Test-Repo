//package com.sharepont.incture.fileuploader.model;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//
//import com.microsoft.graph.concurrency.ChunkedUploadProvider;
//import com.microsoft.graph.concurrency.IProgressCallback;
//import com.microsoft.graph.core.ClientException;
//import com.microsoft.graph.models.extensions.DriveItem;
//import com.microsoft.graph.models.extensions.DriveItemUploadableProperties;
//import com.microsoft.graph.models.extensions.IGraphServiceClient;
//import com.microsoft.graph.models.extensions.UploadSession;
//
//public class UploadToSharePoint {
//
//	private InputStream getInputStream() throws FileNotFoundException {
//		// Get an input stream for the file
//		InputStream fileStream = new FileInputStream(
//				"C:\\Users\\Dipanjan.Baidya\\Desktop\\final_upload\\fileuploader\\fileuploader\\src\\main\\resources\\sample.txt");
//		return fileStream;
//	}
//
//	private void getFileName(InputStream inputStream) throws FileNotFoundException {
//		InputStream fileStream = new FileInputStream(
//				"C:\\Users\\Dipanjan.Baidya\\Desktop\\final_upload\\fileuploader\\fileuploader\\src\\main\\resources\\sample.txt");
//	}
//
//	private long getStreamSize(InputStream fileStream) throws IOException {
//		long streamSize = (long) fileStream.available();
//		return streamSize;
//	}
//
//	// Create a callback used by the upload provider
//	IProgressCallback<DriveItem> callback = new IProgressCallback<DriveItem>() {
//		@Override
//		// Called after each slice of the file is uploaded
//		public void progress(final long current, final long max) {
//			System.out.println(String.format("Uploaded %d bytes of %d total bytes", current, max));
//		}
//
//		@Override
//		public void success(final DriveItem result) {
//			System.out.println(String.format("Uploaded file with ID: %s", result.id));
//		}
//
//		public void failure(final ClientException ex) {
//			System.out.println(String.format("Error uploading file: %s", ex.getMessage()));
//		}
//	};
//
//	public void setUploadSession() throws IOException {
//		final IGraphServiceClient graphClient = new AuthenticationProvider().getAuthProvider();
//
//		// upload to share point
//		UploadSession uploadSession1 = graphClient.sites().byId("912df12f-2b76-411a-8d38-fd3628fb3ded").drive().root()
//				.itemWithPath("sample.txt").createUploadSession(new DriveItemUploadableProperties()).buildRequest()
//				.post();
//
//		ChunkedUploadProvider<DriveItem> chunkedUploadProvider = new ChunkedUploadProvider<DriveItem>(uploadSession1,
//				graphClient, getInputStream(), getStreamSize(getInputStream()), DriveItem.class);
//
//		// Config parameter is an array of integers
//		// customConfig[0] indicates the max slice size
//		// Max slice size must be a multiple of 320 KiB
//		int[] customConfig = { 320 * 1024 };
//
//		// Do the upload
//		chunkedUploadProvider.upload(callback, customConfig);
//	}
//}
