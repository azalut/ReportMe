<@layout.extends name="template.ftl">
    <@layout.put block="content">
        <#-- displays suitable message, depends if activation was successful or not -->
        <#if isConfirmationSucceed>
            <p>Twoje konto zostało aktywowane</p>
        <#else>
            <p>Wystąpił błąd podczas aktywacji konta</p>
        </#if>

        <#-- if exception occured (so page was created by RegisterControllerAdvice not RegisterController-->
        <#if exception??>
            <p>${exception.message!""}</p>
        </#if>
    </@layout.put>
</@layout.extends>