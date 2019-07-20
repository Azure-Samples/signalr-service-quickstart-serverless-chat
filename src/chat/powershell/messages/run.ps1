using namespace System.Net

param($Request, $TriggerMetadata)

$message = [PSCustomObject]@{
    Target = "newMessage"
    Arguments = @($Request.Body)
}
Push-OutputBinding -Name SignalRMessages -Value $message
