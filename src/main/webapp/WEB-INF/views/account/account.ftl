<#import "/spring.ftl" as spring/>

<@layout.extends name="template.ftl">
    <@layout.put block="content">
        <@spring.bind "personObj"/>
        Twoje imie to: ${personObj.personData.name!"BRAK!"} ${personObj.personData.lastname!"BRAK!"}
    </@layout.put>
</@layout.extends>