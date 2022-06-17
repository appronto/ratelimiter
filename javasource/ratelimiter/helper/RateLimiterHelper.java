package ratelimiter.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.util.concurrent.RateLimiter;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;

public class RateLimiterHelper {
	
	//to support multiple ratelimiters
	public static RateLimiter getLimiter(java.math.BigDecimal limitSize) {
		if(limitSize == null)
			return rateLimiter;
		if( RateLimiterMap.containsKey(limitSize.doubleValue()) )
			return RateLimiterMap.get(limitSize.doubleValue());
		else
			RateLimiterMap.put(limitSize.doubleValue(), RateLimiter.create(limitSize.doubleValue()));
			return RateLimiterMap.get(limitSize.doubleValue());
	}
	
	public static RateLimiter getLimiter() {
		return rateLimiter;
	}

	public static ILogNode log = Core.getLogger(ratelimiter.proxies.constants.Constants.getLognode());
	private static RateLimiter rateLimiter = RateLimiter.create(ratelimiter.proxies.constants.Constants.getRateLimit());
	private static Map<Double, RateLimiter> RateLimiterMap = new ConcurrentHashMap<>();

}
