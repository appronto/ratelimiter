// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package ratelimiter.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the RateLimiter module
	public static void test_Queue_Subflow(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("RateLimiter.Test_Queue_Subflow").withParams(params).execute(context);
	}
	public static boolean test_ReturnObject_NoParamMF(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("RateLimiter.Test_ReturnObject_NoParamMF").withParams(params).execute(context);
	}
	public static boolean test_ReturnObject_NoParamMF_NoReturn(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("RateLimiter.Test_ReturnObject_NoParamMF_NoReturn").withParams(params).execute(context);
	}
	public static boolean test_ReturnObject_WithParamMF(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("RateLimiter.Test_ReturnObject_WithParamMF").withParams(params).execute(context);
	}
	public static boolean test_ReturnObject_WithParamMF_Queue(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("RateLimiter.Test_ReturnObject_WithParamMF_Queue").withParams(params).execute(context);
	}
	public static boolean test_Throttling_10sec_DefaultLimit(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("RateLimiter.Test_Throttling_10sec_DefaultLimit").withParams(params).execute(context);
	}
	public static boolean test_Throttling_5sec_Limit(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("RateLimiter.Test_Throttling_5sec_Limit").withParams(params).execute(context);
	}
	public static boolean test_Throttling_Sleep(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		return (java.lang.Boolean) Core.microflowCall("RateLimiter.Test_Throttling_Sleep").withParams(params).execute(context);
	}
	public static system.proxies.Language testMicroflow(IContext context, system.proxies.Language _language)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Language", _language == null ? null : _language.getMendixObject());
		IMendixObject result = (IMendixObject)Core.microflowCall("RateLimiter.TestMicroflow").withParams(params).execute(context);
		return result == null ? null : system.proxies.Language.initialize(context, result);
	}
	public static void testMicroflow_NoParam(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("RateLimiter.TestMicroflow_NoParam").withParams(params).execute(context);
	}
	public static void testMicroflow_Sleep10(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("RateLimiter.TestMicroflow_Sleep10").withParams(params).execute(context);
	}
	public static void testQueue(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("RateLimiter.TestQueue").withParams(params).execute(context);
	}
}