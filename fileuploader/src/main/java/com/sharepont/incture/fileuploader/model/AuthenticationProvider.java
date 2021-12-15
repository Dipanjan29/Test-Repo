//package com.sharepont.incture.fileuploader.model;
//
//import com.microsoft.graph.auth.enums.NationalCloud;
//import com.microsoft.graph.auth.publicClient.UsernamePasswordProvider;
//import com.microsoft.graph.models.extensions.IGraphServiceClient;
//import com.microsoft.graph.requests.extensions.GraphServiceClient;
//
//import java.io.IOException;
//
//public class AuthenticationProvider {
//
//	private static AuthenticationProvider authenticationProvider = null;
//
//	public AuthenticationProvider() {
//	}
//
//	public static AuthenticationProvider getInstance() {
//		if (authenticationProvider == null) {
//			authenticationProvider = new AuthenticationProvider();
//		}
//		return authenticationProvider;
//	}
//
//	public IGraphServiceClient getAuthProvider() throws IOException {
//
//		UsernamePasswordProvider authProvider = new UsernamePasswordProvider(ApplicationProperties.getClientId(),
//				ApplicationProperties.getScopeList(), ApplicationProperties.getUsername(),
//				ApplicationProperties.getPassword(), NationalCloud.Global, ApplicationProperties.getTenantId(),
//				ApplicationProperties.getClientSecret());
//
//		IGraphServiceClient graphClient = GraphServiceClient.builder().authenticationProvider(authProvider)
//				.buildClient();
//
//		return graphClient;
//	}
//}
