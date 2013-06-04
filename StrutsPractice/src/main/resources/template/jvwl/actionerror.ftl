
<#if (actionErrors?? && actionErrors?size > 0)>

	<#list actionErrors as error>
		<#if error?if_exists != "">
            <span><#if parameters.escape>${error!?html}<#else>${error!}</#if></span><#rt/>
        </#if>
	</#list>
	
</#if>