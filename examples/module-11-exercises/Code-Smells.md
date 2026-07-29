`System.out.print("Specific Message");` is a code smell because it uses a hardcoded value that is not configurable. This can lead to issues if the message needs to be changed in the future, as it would require modifying the source code and recompiling the application. Instead, consider using a configuration file or a constant variable to store the message, allowing for easier updates and better maintainability.

`CustomerNotifier.notifyActivated(customerId) {`\
    `String NotificationMessage`\
    `if customerId exists and is active, print NotificationMessage`


Stronger prompts name CustomerNotifier so AI does not bury I/O inside CustomerService.