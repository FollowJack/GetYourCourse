<%@ page import="Courses.Course" %>



<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="course.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${courseInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="course.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${courseInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'isPaymentNeeded', 'error')} ">
	<label for="isPaymentNeeded">
		<g:message code="course.isPaymentNeeded.label" default="Is Payment Needed" />
		
	</label>
	<g:checkBox name="isPaymentNeeded" value="${courseInstance?.isPaymentNeeded}" />
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'maxParticipantAmount', 'error')} required">
	<label for="maxParticipantAmount">
		<g:message code="course.maxParticipantAmount.label" default="Max Participant Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxParticipantAmount" type="number" value="${courseInstance.maxParticipantAmount}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'registeredMembers', 'error')} ">
	<label for="registeredMembers">
		<g:message code="course.registeredMembers.label" default="Registered Members" />
		
	</label>
	<g:select name="registeredMembers" from="${Courses.Participant.list()}" multiple="multiple" optionKey="id" size="5" value="${courseInstance?.registeredMembers*.id}" class="many-to-many"/>
</div>

