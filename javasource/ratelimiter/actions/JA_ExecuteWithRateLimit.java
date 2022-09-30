// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package ratelimiter.actions;

import java.util.Map.Entry;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IDataType;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import ratelimiter.helper.RateLimiterHelper;

/**
 * Limits the number of microflow calls within a period of time per second. 
 * 
 * - The limit can be set by a Decimal per second by the constant RateLimit  or as a parameter of this action
 * 
 * - If the RatelimitQueueName is provided it works as a pool. In this case, you can manage multiple ratelimits
 * 
 * - Cannot be run in a TaskQueue (Mx9) directly. Create a microflow that runs in a Task Queue and call this Java action :)
 * 
 * - Returns an object
 */
public class JA_ExecuteWithRateLimit extends CustomJavaAction<IMendixObject>
{
	private java.lang.String microflowToExecute;
	private IMendixObject microflowParameter;
	private java.lang.String ratelimitQueueName;
	private java.math.BigDecimal limitSize;
	private java.lang.String microflowReturnType;

	public JA_ExecuteWithRateLimit(IContext context, java.lang.String microflowToExecute, IMendixObject microflowParameter, java.lang.String ratelimitQueueName, java.math.BigDecimal limitSize, java.lang.String microflowReturnType)
	{
		super(context);
		this.microflowToExecute = microflowToExecute;
		this.microflowParameter = microflowParameter;
		this.ratelimitQueueName = ratelimitQueueName;
		this.limitSize = limitSize;
		this.microflowReturnType = microflowReturnType;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		RateLimiterHelper.RateLimiter(limitSize, ratelimitQueueName).acquire(1);
				
		if(Core.getReturnType(microflowToExecute).getObjectType() != null && !Core.getReturnType(microflowToExecute).getObjectType().equals(microflowReturnType) ) {
			throw new IllegalArgumentException(Core.getReturnType(microflowToExecute).getObjectType() + " return expected. "+ microflowReturnType + " was given"); 
		}
		
	    //First build the parameter mapping
		java.util.Map<String, Object> params = new java.util.HashMap<>();
		
		for(Entry<String,IDataType> entry : Core.getInputParameters(microflowToExecute).entrySet())
		{
			String inputParameterName = entry.getKey();
			if(microflowParameter == null || !microflowParameter.getType().equals(entry.getValue().getObjectType()) ) {
				throw new IllegalArgumentException(entry.getValue().getObjectType() + " expected. "+ (microflowParameter == null ? "empty object" : microflowParameter.getType()) + " was given"); 
			}
			params.put(inputParameterName, microflowParameter);
		}
		
		//execute microflow
		RateLimiterHelper.log.debug("start to execute "+ microflowToExecute + (ratelimitQueueName != null ? "with queue: "+ratelimitQueueName :"") +" with "+ (limitSize != null ? limitSize.toString() : ratelimiter.proxies.constants.Constants.getRateLimit().toString()) +" per sec");

		return Core.microflowCall(microflowToExecute)
				.inTransaction(true)
				.withParams(params)
				.execute(this.getContext());
 
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "JA_ExecuteWithRateLimit";
	}

	// BEGIN EXTRA CODE
	
	// END EXTRA CODE
}
