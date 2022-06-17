# ratelimiter
Limits the amount of microflow calls within a period of time per second. 

Features:
- The limit can be set by a Decimal per second by the constant RateLimit or as a parameter of this action
- If the LimitSize is provided it works as a pool, so if you provide 5 then all the actions you call with LimitSize 5 uses that pool. In this case, you can manage multiple ratelimits

Limitations:
- Cannot be run in a TaskQueue (Mx9) directly. Create a microflow that runs in a Task Queue and call this Java action :)
