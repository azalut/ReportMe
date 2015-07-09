<#import "/spring.ftl" as spring/>

<@layout.extends name="template.ftl">
    <@layout.put block="content">
        <@spring.bind "person"/>
        Twoje imie to: ${person.personData.name!"BRAK!"} ${person.personData.lastname!"BRAK!"}
    </@layout.put>
</@layout.extends>