<%@ page import="Courses.Participant" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'participant.label', default: 'Participant')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-participant" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                  default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-participant" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list participant">

        <g:if test="${participantInstance?.userId}">
            <li class="fieldcontain">
                <span id="userId-label" class="property-label"><g:message code="participant.userId.label"
                                                                          default="User Id"/></span>

                <span class="property-value" aria-labelledby="userId-label"><g:fieldValue bean="${participantInstance}"
                                                                                          field="userId"/></span>

            </li>
        </g:if>

        <g:if test="${participantInstance?.hasPayed}">
            <li class="fieldcontain">
                <span id="hasPayed-label" class="property-label"><g:message code="participant.hasPayed.label"
                                                                            default="Has Payed"/></span>

                <span class="property-value" aria-labelledby="hasPayed-label"><g:formatBoolean
                        boolean="${participantInstance?.hasPayed}"/></span>

            </li>
        </g:if>

        <g:if test="${participantInstance?.registeredDate}">
            <li class="fieldcontain">
                <span id="registeredDate-label" class="property-label"><g:message
                        code="participant.registeredDate.label" default="Registered Date"/></span>

                <span class="property-value" aria-labelledby="registeredDate-label"><g:formatDate
                        date="${participantInstance?.registeredDate}"/></span>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${participantInstance?.id}"/>
            <g:link class="edit" action="edit" id="${participantInstance?.id}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
