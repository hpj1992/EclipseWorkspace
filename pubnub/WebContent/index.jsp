<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://cdn.pubnub.com/pubnub-dev.js"></script>

<!-- Instantiate PubNub -->
<script type="text/javascript">

 /*    var PUBNUB_demo = PUBNUB.init({
        publish_key: 'pub-c-ad27e60f-ca68-4f05-9c9b-c0e8ee90ade0',
        subscribe_key: 'sub-c-5e172cf6-d286-11e4-bf74-02ee2ddab7fe'
    });

     */
    PUBNUB_demo.subscribe({
        channel: 'demo_tutorial',
        message: function(m){console.log(m)}
    });

    PUBNUB_demo.publish({
        channel: 'demo_tutorial',
        message: {"color":"blue"}
    });
    
    PUBNUB.init({
    	subscribe_key: 'sub-c-5e172cf6-d286-11e4-bf74-02ee2ddab7fe'
    	}).subscribe({
    	channel : 'pubnub-twitter',
    	message : function(msg){ console.log(msg) }
    	});

</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>