<?xml version="1.0" encoding="GB18030" ?>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<title>Struts-Tagsѧϰ</title>
</head>
<body>
	<ol>
		<%-- <li>property: <s:property value="username"/> </li>
		<li>property ȡֵΪ�ַ���: <s:property value="'username'"/> </li>
		<li>property �趨Ĭ��ֵ: <s:property value="'admin'" default="����Ա"/> </li> --%>
		<li>property �趨HTML: <s:property value="'<hr/>'" escape="false"/>  �����escape����Ϊture�� �Ὣ<s:property value="'<hr/>'" escape="true"/> �����ַ������ </li>
		<hr />
		<li>set �趨adminNameֵ��Ĭ��Ϊrequest �� ActionContext��: <s:set var="adminName" value="username" /></li>
		
		<li>set ��requestȡֵ: <s:property value="#request.adminName" /></li>
		<li>set ��ActionContextȡֵ: <s:property value="#adminName" /></li>
		
		<%--<li>set �趨��Χ: <s:set name="adminPassword" value="password" scope="page"/></li>
		<li>set ����Ӧ��Χȡֵ: <%=pageContext.getAttribute("adminPassword") %></li>
		--%>
		<li>set �趨var����ΧΪActionContext: <s:set var="adminPassword" value="password" scope="session"/></li>
		<li>set ʹ��#ȡֵ: <s:property value="#adminPassword"/> </li>
		<li>set ����Ӧ��Χȡֵ: <s:property value="#session.adminPassword"/> </li>
		
		<hr />
		
		<li>Value���ṩ�����ַ�ʽ��ͨ��value���Ի��߱�ǩ�м��text����֮ͬ���� </li>
		<s:url value="editEmp.action" >  
    		<%-- <s:param name="name">zhaosoft</s:param> --%>
			<li>��������String�ĸ�ʽ����statck</li>
			<s:param name="implid" value="1"/>
			<li>��ֵ����java.lang.Object�ĸ�ʽ����statck</li>
		</s:url>
		
		<%--<li>push:<s:set name="myDog" value="new com.bjsxt.struts2.ognl.Dog('oudy')"></s:set></li>
		<li>
		push:<s:push value="#myDog">
			<s:property value="name"/>
		</s:push>
		</li>
		<li>push: <s:property value="name"/></li>
		
		
		<hr />
		<li>bean ����bean,��ʹ��param���趨�µ�����ֵ:
			<s:bean name="com.smile.struts2.bean.Dog" >
				<s:param name="name" value="'pp'"></s:param>
				<s:property value="name"/>
				
			</s:bean>
			
			s:beanִ������֮��ͽ�valuestack�е�ֵ��ջ
			
			
		</li>
		
		<li>bean �鿴debug���:
			<s:bean name="com.smile.struts2.bean.Dog" var="myDog">
				<s:param name="name" value="'oudy'"></s:param>
			</s:bean>
			�ó�ֵ��
			<s:property value="#myDog.name"/>
			<s:debug></s:debug>
		</li>
		<hr />
		
		<li>include _include1.html ������̬Ӣ���ļ�
		<s:include value="/_include1.html"></s:include>
		</li>
		
		<li>include _include2.html ������̬�����ļ�
		<s:include value="/_include2.html"></s:include>
		</li>
		
		<li>include _include1.html ������̬Ӣ���ļ���˵��%�÷�
		<s:set var="incPage" value="%{'/_include1.html'}" />
		<s:include value="%{#incPage}"></s:include>
		</li>
		
		--%>
		<hr />
		
		<li>if elseif else: 
		age = <s:property value="#parameters.age[0]" /> <br />
		<s:set var="age" value="#parameters.age[0]" />
		
		<s:if test="#age < 0">wrong age!</s:if>
		<s:elseif test="#parameters.age[0] < 20">too young!</s:elseif>
		<s:else>yeah!</s:else><br />
		
		<s:if test="#parameters.aaa == null">null</s:if>
		</li>
		
		<hr />
		
		<li>�������ϣ�<br />
		<s:iterator value="{1, 2, 3}" >
			<s:property/> |
		</s:iterator>
		</li>
		<li>�Զ��������<br />
		<s:iterator value="{'aaa', 'bbb', 'ccc'}" var="x">
			<s:property value="#x.toUpperCase()"/> |
		</s:iterator>
		</li>
		<li>ʹ��status:<br />
		<s:iterator value="{'aaa', 'bbb', 'ccc'}" status="status">
			<s:property/> | 
			��������Ԫ��������<s:property value="#status.count"/> |
			��������Ԫ��������<s:property value="#status.index"/> |
			��ǰ��ż������<s:property value="#status.even"/> |
			��ǰ����������<s:property value="#status.odd"/> |
			�ǵ�һ��Ԫ���𣿣�<s:property value="#status.first"/> |
			�����һ��Ԫ���𣿣�<s:property value="#status.last"/>
			<br />
		</s:iterator>
		
		</li>
		
		<li>
		<s:iterator value="#{1:'a', 2:'b', 3:'c'}" >
			<s:property value="key"/> | <s:property value="value"/> <br />
		</s:iterator>
		</li>
		
		<li>
		<s:iterator value="#{1:'a', 2:'b', 3:'c'}" var="x">
			<s:property value="#x.key"/> | <s:property value="#x.value"/> <br />
		</s:iterator>
		</li>
		
		<li>
		
		<s:fielderror fieldName="fielderror.test" theme="simple"></s:fielderror>
		
		</li>
		<hr/>
		
		UI��ǩ
		<s:form>
		    <s:select label="���ѧ��" name="education" list="{'����','��ѧ','˶ʿ','��ʿ'}"
		       headerKey="-1" headerValue="��ѡ������ѧ��"/>
		</s:form>
		
		<s:form name="test">
    		<s:doubleselect label="��ѡ������ʡ��"
       		name="province" list="{'�Ĵ�ʡ','ɽ��ʡ'}" doubleName="city"
       		doubleList="top == '�Ĵ�ʡ' ? {'�ɶ���', '������'} : {'������', '�ൺ��'}" />
		</s:form>
		
		<s:form>
    		<s:checkboxlist name="interest" list="{'����','����','����','��Ӿ'}" label="��Ȥ����"/>
		</s:form>
		
		<s:form action="login">
   			<s:textfield name="user.username" label="�û���"></s:textfield>
   			<s:textfield name="user.password" label="����"></s:textfield>
   			<s:submit value="��½"></s:submit>
   			<s:submit value="ע��" name="action:register"></s:submit>
   			<s:submit value="����" name="redirect:www.google.com"></s:submit>
		</s:form>
		
		<s:form>
			<!-- ʹ�ü򵥼��������ɿ������ƶ�ѡ�������ѡ��� -->
			<s:updownselect name="a" label="��ѡ����ϲ����ͼ��" labelposition="top"
	    	moveUpLabel="�����ƶ�"
	    	list="{'Spring2.0����' , '������J2EE��ҵӦ��ʵս' , 'JavaScript: The Definitive Guide'}"/>
			<!-- ʹ�ü�Map���������ɿ������ƶ�ѡ�������ѡ�����ʹ��emptyOption="true"����һ����ѡ��-->
			<s:updownselect name="b" label="��ѡ������ѡ���������" labelposition="top"
	    	moveDownLabel="�����ƶ�" list="#{'Spring2.0����':'2006��10��' , '������J2EE��ҵӦ��ʵս':'2007��4��' , '����J2EE��Ajax����':'2007��6��'}"
	    	listKey="key"
	    	emptyOption="true"
	   	 	listValue="value"/>
			<!-- ʹ�ü�����Ŷ��JavaBeanʵ�����������ƶ�ѡ�����������ѡ��� -->
	
		<%-- 	<s:bean name="com.xuyuan.ssj.service.EmpServiceImpl" id="ds" />
			<s:updownselect name="c" label="��ѡ����ϲ����ͼ�������" labelposition="top"
	    	selectAllLabel="ȫ��ѡ��" multiple="true"
	    	list="#ds.dogs"
	    	listKey="author"
	    	listValue="name"/> --%>
		</s:form>
		
		<s:form>
    		<s:optiontransferselect
	    	label="��ϲ����ͼ��"
	        name="book1"
	        leftTitle="Javaͼ��"
	        rightTitle="C/C++ͼ��"
	        list="{'��Java Web������⡷', '��Struts 2������⡷', '��Java�������š�'}"
	        headerKey="-1"
	        headerValue="--- ��ѡ�� ---"
	        emptyOption="true"
	        doubleName="book2"
	        doubleList="{'��VC++������⡷', '��C++ Primer��', '��C++����������ԡ�'}"
	        doubleHeaderKey="-1"
	        doubleHeaderValue="--- ��ѡ�� ---"
	        doubleEmptyOption="true"
	        addToLeftLabel="�����ƶ�"
	        addToRightLabel="�����ƶ�"
	        addAllToLeftLabel="ȫ������"
	        addAllToRightLabel="ȫ������"
	        selectAllLabel="ȫ��ѡ��"
	        leftUpLabel="�����ƶ�"
	        leftDownLabel="�����ƶ�"
	        rightUpLabel="�����ƶ�"
	        rightDownLabel="�����ƶ�"/>
		</s:form>
	</ol>
	
	
	
	
</body>
</html>