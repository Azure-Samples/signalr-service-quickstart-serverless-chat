import json
import azure.functions as func

def main(req: func.HttpRequest) -> str:
    message = req.get_json()
    return json.dumps({
        'target': 'newMessage',
        'arguments': [ message ]
    })


