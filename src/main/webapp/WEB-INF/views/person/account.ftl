<#import "/spring.ftl" as spring/>

<@layout.extends name="template.ftl">
    <@layout.put block="content">
        <@spring.bind "person"/>
        Twój login to: ${person.personData.name!"BRAK!"}
    </@layout.put>
</@layout.extends>