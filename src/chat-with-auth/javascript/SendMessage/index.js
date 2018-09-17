module.exports = function (context, req) {
    const message = req.body;
    if (req.headers && req.headers['x-ms-client-principal-name']) {
        message.sender = req.headers['x-ms-client-principal-name'];
    }
        
    let recipientUserId = '';
    if (message.recipient) {
        recipientUserId = message.recipient;
        message.isPrivate = true;
    }

    context.bindings.signalRMessages = [{
        "userId": recipientUserId,
        "target": "newMessage",
        "arguments": [ message ]
    }];
    context.done();
};