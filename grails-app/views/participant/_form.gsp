<%@ page import="Courses.Participant" %>



<div class="fieldcontain ${hasErrors(bean: participantInstance, field: 'userId', 'error')} required">
    <label for="userId">
        <g:message code="participant.userId.label" default="User Id"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="userId" type="number" value="${participantInstance.userId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: participantInstance, field: 'hasPayed', 'error')} ">
    <label for="hasPayed">
        <g:message code="participant.hasPayed.label" default="Has Payed"/>

    </label>
    <g:checkBox name="hasPayed" value="${participantInstance?.hasPayed}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: participantInstance, field: 'registeredDate', 'error')} required">
    <label for="registeredDate">
        <g:message code="participant.registeredDate.label" default="Registered Date"/>
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="registeredDate" precision="day" value="${participantInstance?.registeredDate}"/>
</div>

