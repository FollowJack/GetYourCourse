
<%@ page import="Courses.Participant" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'participant.label', default: 'Participant')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-participant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-participant" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="userId" title="${message(code: 'participant.userId.label', default: 'User Id')}" />
					
						<g:sortableColumn property="hasPayed" title="${message(code: 'participant.hasPayed.label', default: 'Has Payed')}" />
					
						<g:sortableColumn property="registeredDate" title="${message(code: 'participant.registeredDate.label', default: 'Registered Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${participantInstanceList}" status="i" var="participantInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${participantInstance.id}">${fieldValue(bean: participantInstance, field: "userId")}</g:link></td>
					
						<td><g:formatBoolean boolean="${participantInstance.hasPayed}" /></td>
					
						<td><g:formatDate date="${participantInstance.registeredDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${participantInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
