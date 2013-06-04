
<#if (actionMessages?? && actionMessages?size > 0 && !parameters.isEmptyList)>
		<#list actionMessages as message>
            <#if message?if_exists != "">
                <span><#if parameters.escape>${message!?html}<#else>${message!}</#if></span>
            </#if>
		</#list>
</#if>