
<#if (actionMessages?? && actionMessages?size > 0 && !parameters.isEmptyList)>
		<#list actionMessages as message>
            <#if message?if_exists != "">
                <#if parameters.escape>${message!?html}<#else>${message!}</#if>
            </#if>
		</#list>
</#if>