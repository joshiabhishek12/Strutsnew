<%@ taglib uri="/struts-tags" prefix="s" %>
<s:form action="update" style="background-image: url('https://www.tendencias.kpmg.es/wp-content/uploads/2018/11/GettyImages-912949110.jpg'); background-repeat: no-repeat; background-size: 100% auto;">
    <s:hidden name="id" value="%{id}" />
    <h1>You can update your product</h1>
    <s:textfield name="name" label="Product Name" value="%{name}" />
    <s:textfield name="price" label="Product Price" value="%{price}" />
    <s:submit value="Update" />
    <s:actionerror />
</s:form>
