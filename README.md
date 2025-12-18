Start User Service
Post -> localhost:8082/users/saveuser
</BR>Add following in Body -> Raw -> json
</BR>{"name":"Pravin Kashelkar","email":"pdkashelkar@gmail.com","location":"Dombivali"}
</BR>
</BR>GET -> localhost:8082/users/user/1
</BR>
</BR>Start Order Service
</BR>GET -> localhost:8083/orders/user/1
</BR>
</BR>Close User Service
</BR>GET -> localhost:8083/orders/user/1
