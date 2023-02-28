package mx.com.cdc.odc.client.api;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import mx.com.cdc.odc.client.ApiCallback;
import mx.com.cdc.odc.client.ApiClient;
import mx.com.cdc.odc.client.ApiException;
import mx.com.cdc.odc.client.ApiResponse;
import mx.com.cdc.odc.client.Configuration;
import mx.com.cdc.odc.client.Pair;
import mx.com.cdc.odc.client.model.AggregationServiceResponsePayload;
import mx.com.cdc.odc.client.model.EnergyRequestPayload;

public class EnergyApi {
    private ApiClient apiClient;
    
    public EnergyApi() {
        this(Configuration.getDefaultApiClient());
    }
    
    public EnergyApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public ApiClient getApiClient() {
        return apiClient;
    }
    
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call getEnergyCall(
    		String xApiKey, 
    		String subscriptionId, 
    		String username, 
    		String password,
    		EnergyRequestPayload body) throws ApiException {
        
    	Object localVarPostBody = body;
        String localVarPath = "/energy";
        
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        
        if (xApiKey != null)
        	localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        
        if (subscriptionId != null)
        	localVarHeaderParams.put("subscription-id", apiClient.parameterToString(subscriptionId));
        
        if (username != null)
        	localVarHeaderParams.put("username", apiClient.parameterToString(username));
        
        if (password != null)
        	localVarHeaderParams.put("password", apiClient.parameterToString(password));
        
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        
        final String[] localVarAccepts = {
            "application/json"
        };
        
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        
        if (localVarAccept != null) 
        	localVarHeaderParams.put("Accept", localVarAccept);
        
        final String[] localVarContentTypes = {
            "application/json"
        };
        
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        
        String[] localVarAuthNames = new String[] {  };
        
        return apiClient.buildCall(
        		localVarPath, 
        		"POST", 
        		localVarQueryParams, 
        		localVarCollectionQueryParams, 
        		localVarPostBody, 
        		localVarHeaderParams, 
        		localVarFormParams, 
        		localVarAuthNames, 
        		null);
    }

    private okhttp3.Call getEnergyValidateBeforeCall(
    		String xApiKey, 
    		String subscriptionId, 
    		String username, 
    		String password,
    		EnergyRequestPayload body) throws ApiException {
        
    	if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getEnergy(Async)");
        }
        
    	if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling getEnergy(Async)");
    	}
        
    	if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling getEnergy(Async)");
        }
        
    	if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling getEnergy(Async)");
        }
        
    	if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling getEnergy(Async)");
        }
        
        okhttp3.Call call = getEnergyCall(
        		xApiKey, 
        		subscriptionId, 
        		username, 
        		password,
        		body);
        
        return call;
    }
    
    public AggregationServiceResponsePayload getEnergy(
    		String xApiKey, 
    		String subscriptionId, 
    		String username, 
    		String password, 
    		EnergyRequestPayload body) throws ApiException {
        
    	ApiResponse<AggregationServiceResponsePayload> resp = getEnergyWithHttpInfo(
    			xApiKey, 
    			subscriptionId, 
    			username, 
    			password,
    			body);
    	
        return resp.getData();
    }
    
    public ApiResponse<AggregationServiceResponsePayload> getEnergyWithHttpInfo(
    		String xApiKey, 
    		String subscriptionId, 
    		String username, 
    		String password,
    		EnergyRequestPayload body) throws ApiException {
        
    	okhttp3.Call call = getEnergyValidateBeforeCall(
    			xApiKey, 
    			subscriptionId, 
    			username, 
    			password,
    			body);
    	
        Type localVarReturnType = new TypeToken<AggregationServiceResponsePayload>(){}.getType();
        
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call getEnergyAsync(
    		String xApiKey, 
    		String subscriptionId, 
    		String username, 
    		String password,
    		EnergyRequestPayload body, 
    		final ApiCallback<AggregationServiceResponsePayload> callback) throws ApiException {
    	
        
        okhttp3.Call call = getEnergyValidateBeforeCall(
        		xApiKey, 
        		subscriptionId, 
        		username, 
        		password,
        		body);
        
        return call;
    }
}
