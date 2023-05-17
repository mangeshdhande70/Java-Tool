<%@ taglib prefix="mine" uri="/WEB-INF/loop.tld" %>

<h1>Hello this is Custom Tag </h1>

<mine:loop count='5' >

	<h1 style="color:red;">This is the body of custom Loop tag</h1>
</mine:loop>

<h1>This is after the custom tag invocation</h1>