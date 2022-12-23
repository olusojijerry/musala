# musala
Musala Soft Drones Project

Various Modules included in the project

The database used to build the application is H2 in memory database

1. Drone - Api
This is the API layer of the project it includes serveral apis with JSON as their payload and the return type also as JSON.
The application runs on port 9000
All responses in the project has specific type which include
Message: this tells if it is a failure or a successful api call.
Data: this gives the result that is expected by the api.
Success: this boolean variable it tells if the api call was a success (for true) or a failure (with false value).
status: this returns the error code (400, 200, 500)

Api Collection in the project
1. Create Drone: This api is used to create new drone that are brought to the company.
  Request Type: POST 
  Url: {BASE_URL}\api\drone
  Payload: {
    "model": "Lightweight",
    "weight": 20.00,
    "batteryCapacity": 98.99,
    "state": "IDLE",
    "serial": "22122022-ee099ed8-0597-4bd6-e160f982c14e"
}
Response: {
    "message": "Successful",
    "success": true,
    "data": {
        "id": 1,
        "serialNumber": "22122022-ee099ed8-0597-4bd6-e160f982c14e",
        "model": "Lightweight",
        "weight": 20.0,
        "status": "IDLE",
        "batteryCapacity": 100.0,
        "createdDt": "2022-12-23T17:15:07.256+00:00",
        "lastActivityDt": null
    },
    "status": 200
}

Description of each attribute
serial number (100 characters max);
model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
weight limit (500gr max);
battery capacity (percentage);
state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).

2. Get all Drones Activity: This api returns all activity that has been done by a drone.
  Request Type: GET
  Url: {BASE_URL}\api\drone\activity
  Request Param: droneSerial
  Response: {
    "message": "Successful",
    "success": true,
    "data": [
        {
            "id": 1,
            "status": "IDLE",
            "batteryCapacity": 100.0,
            "createdDt": "2022-12-23T17:15:07.352+00:00",
            "droneSerial": "22122022-ee099ed8-0597-4bd6-e160f982c14e",
            "destination": null,
            "action": "Newly Created Drone"
        },
        {
            "id": 2,
            "status": "IDLE",
            "batteryCapacity": 100.0,
            "createdDt": "2022-12-23T17:17:38.031+00:00",
            "droneSerial": "22122022-ee099ed8-0597-4bd6-e160f982c14e",
            "destination": null,
            "action": "Update Drone Status"
        }
    ],
    "status": 200
}

Description of each attribute
destination: this describes where the place of delivery.
action: this describes what was done.

3. Get all existing Drones
    Returns all the Drones that has been created on the System.
    Request Type: GET
    Url: {BASE_URL}\api\drone\all
    Response: {
    "message": "Successful",
    "success": true,
    "data": [
        {
            "id": 1,
            "serialNumber": "22122022-ee099ed8-0597-4bd6-e160f982c14e",
            "model": "Lightweight",
            "weight": 20.0,
            "status": "IDLE",
            "batteryCapacity": 100.0,
            "createdDt": "2022-12-23T18:16:28.456+00:00",
            "lastActivityDt": null
        }
    ],
    "status": 200
}

4. Create Medication
  Request Type: Post
  Url: {BASE_URL}\api\medication
  Request Body: {
    "name": "CHLORO",
    "weight": 5.00,
    "code": "123-ADD-MED-OFAQ",
    "image": "MjAwCjE2ODA5IDEyMyAxMTY2OAoyMDM3MyAxODIxMSAxMDE4OAo5MjUxMiA0MTMgMzMwNDAKMjMzOSA0IDEzMzcKOTY3NDEgOTQ1IDc3MTk0CjUzMjcwIDE4MiAzMDIzOAo0NzczMyAyMzAgNDg0MAo2MDc1MSAzNDYgMjA1NzgKMTkxNTAgOTkgMjk0NQo5NDU2NiA1MTQgNDc1ODMKMTcyNzQgNTIzNCAxMjg4NQozOTQ3OCAzNjQgMjM5OTEKNDYwNTIgMzg4IDQzMDI4CjIxODE2IDE0NjQ1IDE4MjcKOTg1NzMgNzQxMjAgNDQ0MzcKNDcxNTEgNzggMjg1MjYKMTg5OTEgNzggMTAwMTAKMjg1ODMgMTEzIDUyOTkKMzQ1ODcgODYgMzMzMzQKNTkyNzIgMjQ5NDYgNDQ0MTYKNDE4OTQgMzYgNjQwCjY1MTY0IDUyMiAyMzcyOAo0MDkxNiAzOTkgMzA2NzAKNzA0NSAyNSA2NDg0CjQ1NTY3IDYzIDc1NjQKNjMwNDEgMzAyIDUwODcwCjE0NDQwIDMgMjc1CjMzNzczIDEzMTc5IDY5MjkKNzE2NTYgMzI1IDUyMzc1CjE1NzUgMSAyNjIKMjIxNiA4IDM1CjE2OTc0IDEyNDggNjA5MAo3NDg5MiAzMTQgNDgzNDAKNDUzMTIgODQ4IDQ0MTk4Cjk2NDI4IDgxMTQ0IDQzMDY2CjYxMjY0IDk2IDE0MzAwCjUyNzM0IDQ4OSA0MDc0OQo0Mjc1MSAxMjUgODg1MAo1MTgwMyAyNSAzODI1MwoxNTAxMiA2ODA2IDIzNjAKNDE0NDcgOTQgODk0NgozNTg0OSAzNDMgMjg5MTAKMzI3MTUgMTIzIDIxNTc4CjQzMzQ0IDQyNSA3OTQ5CjQxOTg2IDEwNCAxODI2OQo0ODkzIDM3IDkyMQoxMzI0MyAxMDggMTA4NDUKNDU5OTYgMjQxNTMgMzgwODAKNDg2MzAgMzY2IDQ4Mzg4CjY2NDc0IDU2MCA1MDQ4OAo5MDA0MSA2MTMgOTg3OAo1OTc1IDMyIDQwNTkKMjQ4OTIgMTU3IDM3ODMKODUyNzYgNTc5IDQxNjMKNTEwMDUgNTAzIDQ0NDE1CjU2MzY0IDQwNjY4IDUzNDQ5Cjc4MDg5IDU2NiA3MDgwNQo0NDg0MyAyOSA0NDgzOAozMTc3NyAxMjUzOCAxMTAzCjU2MDM3IDU0NSAyNDc0MwozNDYxMiAxMTYgMjE1NjkKNzg4MDYgNTkxIDY0MTg1Cjc2NzkwIDY2MSA0NDcwNAo3NzQxNyA1MiAzNTY1OQo1OTg2MSAyMTkgMzg4NTYKMTA2NDUgOTQgMTA2MjIKNDMzOCAzOSAyNTU2Cjc4NDc5IDUxMyA1OTk0MwoxMjU3NCAxMTMwMyA2NjUwCjIzMzMzIDE1MTc4IDE2NDQ0CjQ2MTQzIDE5OTk0IDI0ODc5Cjc3NDcgNTkgMzU4Nwo3MjI4NiAzMzQgNjk5MDYKOTk3NzAgNzU4IDY5ODA2Cjg1NDg2IDMzMSA0NzE1Mwo4NTAwNiA3ODE1MyAzMDM1OAo2NjE0IDM4ODcgNTc1Mwo5ODA0NiAzMzEgNjg2MDAKMjc0NTQgMjQzMzUgMTc3OTgKOTA0MzAgMTQgMzcwMDQKOTIyODUgOSA1NjM0MQoyNjYyOCAyMDkgNDMzNQo4NzE1OCA1NDAyNCA4NzIxCjczMTkgNTQzMiA2OTQwCjgzMjUzIDMxMDU1IDc2NjAxCjU5OTA4IDU1NiAyMzUyMgo1MjU4NyAyNzcgNTA2MzAKNTE5NDIgMjM0IDI3MzUzCjM4MjI0IDk2MDMgMjIyOTMKMzk3NDkgMzI2IDM4NzU3Cjk0MzcyIDMyNiA0NDU0NAozMTE0OSAyOTIgNDczNQo2MDY5NSAzNDcgMjgzNTUKMjkyOTcgOTEgMTU0NDUKNjA2MDggNTQzIDE3Njg5CjIyMjY4IDI4IDc5NTQKNzYyOCA1NiA1MDc4CjE3NDA0IDk4ODIgMzY0NgoyNjM3NyAxMTk4MSAxMzg0OAo2MDIxNyAxNDQgMjQKNDE4MzUgODkgMzQ5OTkKNzc4NzkgMTc5IDMxMDgyCjY3NzYgNTEgNTQ3Mwo2NDQxOCAxMjcgNTQxODcKODg3NDggODI1IDI1NDM3CjY5MzMyIDI5IDIxNjg3CjM4NjU0IDM3ODA5IDI3NzUyCjg0ODgwIDc1NyA3NjU0MQoyODQ0MSA3NzA1IDQyNzYKNzgwMzcgNjY3IDYxOTYzCjM0Mzg3IDMyNSAyNTkzCjI0Nzc0IDUzIDIzODM3CjU4ODAzIDQzMSA4MjcwCjc0Mjg0IDYwOSA2NzYwCjExODg0IDUxIDY0OTkKMjQ3NjkgNyAxMzEzOAo3NzIzIDcyIDkxNwozNjkxOSAyNjIgMzY0MzEKNTU0ODAgNDk2IDE4MDU0CjgzMjE4IDU3MiAyNzAKMTE4OTYgMTA2IDgwNjEKOTI4NjggMTE5IDYxNjMwCjY3MDI5IDQyNDA2IDY1NDgyCjE2MTUxIDU2NTkgMTM2MTkKNTQzMDUgMzk1IDE3MjcxCjc0MDU0IDcyOTIwIDY1NTQ1CjQ1NzUzIDE5NiAyODU1MQo0MTQ1IDMwMTkgMjYwNwo4MDAyNiA4IDQzNTQwCjQyMzQyIDE3NiAxMzI4Ngo4MjgxIDIzIDU1MTgKOTQ1MTYgMzQxIDQ4NDYzCjM2Njc1IDg5IDEwNzM2Cjg4MTA5IDMxMDM4IDEzOTA1CjQ1MjIyIDIzMjM4IDU5MzMKNzg5MDAgNjYyOTIgNDUzMDIKNjk3MCA2NyAyNDIyCjc1ODUwIDcyOTE4IDY5NTYzCjg4MzMgODggODIyMAo4OTA1NCA1MDM0MSAxMjY5OQoyNjk5NiAxNDIgNzAwMQoyMTc3NCA3MyAxMzU5NAo5NTEzMSAyMzUgOTQ5NTYKMTc0ODkgMTU0IDEzMDE1CjgzMDM2IDYyNSA0MTg1MQo5MjI1NiAzMzMwNCA3ODM0NQo2ODc0MCA2OCAzNDEwOQo1Njc0MSA0NDQ2NCA0NDkzNwo3NjUyNyA0MDYgMjQ5NTYKNDAzMTIgMTUwIDM0NTk2CjY5NDIyIDM5IDM4MDkzCjY4NDU2IDQ2OTQ4IDUwMjY4Cjk5OTE5IDk1OSA1OTA0MQoyMjQyNCAxNzEgMTUzOTEKODUxNTYgNTE2IDUxNDAKNDQzMiAzMCA0MDUzCjI0OTcgMTYwNCAxOTI1CjYyNzA4IDYwMSA3MjY4CjU1MjM4IDgzNDMgODYwMgoxODc4NiAzNCAxNjAyMwo0ODA4NiA4MyAyMjAxOAozNzczOSAxNDMgMjI1MzEKMTc0MjUgNSA5NDcxCjgyNzUgMzAgMTAyMwo2ODI2MyAyOCA1Njk4MAo2MjgwNSA4MjAzIDQ3MDE1CjYyMTQ1IDIyNCA4ODE0CjU4NzE0IDQxNiAxNzMzMwo5ODA0MyA0NTcgOTE4NTgKOTc2MDUgODA3IDI4MzA2CjE4NTcxIDE1NCAxNjg2NAo3MjMzMyA2MzggMTI4MTQKNDI1MDEgMzY3IDE1NTU3CjEzMTg1IDM4NjkgMTEyMDUKNTcyMzUgNDA4NjcgMTEzNzQKNjIyNjkgMzAzOTYgMzc0ODkKNDAwODcgMzg2IDMyNzY2Cjc1NDMgNDQgNDQ1NAo4MDk3MyA3MTEgNDU5ODgKMjY4NDkgMjU3IDE5NzA1CjU3Mzk3IDE2NSAxNjA1NAo1MjY2MiAxNzIgMjI1MzkKMzYxNDEgMTUyIDI1NTE1Cjk2MzMzIDE2MyA5MTc4NQo1MzI3IDM0IDUwODAKMTUyOCAxMzEgMTMwOAoyMjExOCAxMSA4MTEyCjMwMjg1IDUyIDE4NjE3CjIyMDk0IDQxMDQgNDExOAo5ODQ0NiA3NiA3MzA2OQo2NzEwNyAxODQyOSA1NjA5MQoxOTMyNSAxNzUgMTQxNTYKNTEwOTAgMzQzIDEzNjY2CjU0MjU5IDM5MDMwIDQ0ODYwCjUzMzI4IDM5OTU5IDQ4MTAzCjMzNTMzIDI0NSAxNjA2NAo1MDIwNCAyNjEgMzY5OTcKNDU4NiAxNCA5OAo2MzU0OCAyNzcgMjY5MjIKNzg3MTEgNTE0IDYzMzM4",
    "imageType": "jpeg"
}
Response: {
    "message": "Successful",
    "success": true,
    "data": {
        "id": 2,
        "name": "CHLORO",
        "weight": 5.0,
        "code": "123-ADD-MED-OFAQ",
        "image": "MjAwCjE2ODA5IDEyMyAxMTY2OAoyMDM3MyAxODIxMSAxMDE4OAo5MjUxMiA0MTMgMzMwNDAKMjMzOSA0IDEzMzcKOTY3NDEgOTQ1IDc3MTk0CjUzMjcwIDE4MiAzMDIzOAo0NzczMyAyMzAgNDg0MAo2MDc1MSAzNDYgMjA1NzgKMTkxNTAgOTkgMjk0NQo5NDU2NiA1MTQgNDc1ODMKMTcyNzQgNTIzNCAxMjg4NQozOTQ3OCAzNjQgMjM5OTEKNDYwNTIgMzg4IDQzMDI4CjIxODE2IDE0NjQ1IDE4MjcKOTg1NzMgNzQxMjAgNDQ0MzcKNDcxNTEgNzggMjg1MjYKMTg5OTEgNzggMTAwMTAKMjg1ODMgMTEzIDUyOTkKMzQ1ODcgODYgMzMzMzQKNTkyNzIgMjQ5NDYgNDQ0MTYKNDE4OTQgMzYgNjQwCjY1MTY0IDUyMiAyMzcyOAo0MDkxNiAzOTkgMzA2NzAKNzA0NSAyNSA2NDg0CjQ1NTY3IDYzIDc1NjQKNjMwNDEgMzAyIDUwODcwCjE0NDQwIDMgMjc1CjMzNzczIDEzMTc5IDY5MjkKNzE2NTYgMzI1IDUyMzc1CjE1NzUgMSAyNjIKMjIxNiA4IDM1CjE2OTc0IDEyNDggNjA5MAo3NDg5MiAzMTQgNDgzNDAKNDUzMTIgODQ4IDQ0MTk4Cjk2NDI4IDgxMTQ0IDQzMDY2CjYxMjY0IDk2IDE0MzAwCjUyNzM0IDQ4OSA0MDc0OQo0Mjc1MSAxMjUgODg1MAo1MTgwMyAyNSAzODI1MwoxNTAxMiA2ODA2IDIzNjAKNDE0NDcgOTQgODk0NgozNTg0OSAzNDMgMjg5MTAKMzI3MTUgMTIzIDIxNTc4CjQzMzQ0IDQyNSA3OTQ5CjQxOTg2IDEwNCAxODI2OQo0ODkzIDM3IDkyMQoxMzI0MyAxMDggMTA4NDUKNDU5OTYgMjQxNTMgMzgwODAKNDg2MzAgMzY2IDQ4Mzg4CjY2NDc0IDU2MCA1MDQ4OAo5MDA0MSA2MTMgOTg3OAo1OTc1IDMyIDQwNTkKMjQ4OTIgMTU3IDM3ODMKODUyNzYgNTc5IDQxNjMKNTEwMDUgNTAzIDQ0NDE1CjU2MzY0IDQwNjY4IDUzNDQ5Cjc4MDg5IDU2NiA3MDgwNQo0NDg0MyAyOSA0NDgzOAozMTc3NyAxMjUzOCAxMTAzCjU2MDM3IDU0NSAyNDc0MwozNDYxMiAxMTYgMjE1NjkKNzg4MDYgNTkxIDY0MTg1Cjc2NzkwIDY2MSA0NDcwNAo3NzQxNyA1MiAzNTY1OQo1OTg2MSAyMTkgMzg4NTYKMTA2NDUgOTQgMTA2MjIKNDMzOCAzOSAyNTU2Cjc4NDc5IDUxMyA1OTk0MwoxMjU3NCAxMTMwMyA2NjUwCjIzMzMzIDE1MTc4IDE2NDQ0CjQ2MTQzIDE5OTk0IDI0ODc5Cjc3NDcgNTkgMzU4Nwo3MjI4NiAzMzQgNjk5MDYKOTk3NzAgNzU4IDY5ODA2Cjg1NDg2IDMzMSA0NzE1Mwo4NTAwNiA3ODE1MyAzMDM1OAo2NjE0IDM4ODcgNTc1Mwo5ODA0NiAzMzEgNjg2MDAKMjc0NTQgMjQzMzUgMTc3OTgKOTA0MzAgMTQgMzcwMDQKOTIyODUgOSA1NjM0MQoyNjYyOCAyMDkgNDMzNQo4NzE1OCA1NDAyNCA4NzIxCjczMTkgNTQzMiA2OTQwCjgzMjUzIDMxMDU1IDc2NjAxCjU5OTA4IDU1NiAyMzUyMgo1MjU4NyAyNzcgNTA2MzAKNTE5NDIgMjM0IDI3MzUzCjM4MjI0IDk2MDMgMjIyOTMKMzk3NDkgMzI2IDM4NzU3Cjk0MzcyIDMyNiA0NDU0NAozMTE0OSAyOTIgNDczNQo2MDY5NSAzNDcgMjgzNTUKMjkyOTcgOTEgMTU0NDUKNjA2MDggNTQzIDE3Njg5CjIyMjY4IDI4IDc5NTQKNzYyOCA1NiA1MDc4CjE3NDA0IDk4ODIgMzY0NgoyNjM3NyAxMTk4MSAxMzg0OAo2MDIxNyAxNDQgMjQKNDE4MzUgODkgMzQ5OTkKNzc4NzkgMTc5IDMxMDgyCjY3NzYgNTEgNTQ3Mwo2NDQxOCAxMjcgNTQxODcKODg3NDggODI1IDI1NDM3CjY5MzMyIDI5IDIxNjg3CjM4NjU0IDM3ODA5IDI3NzUyCjg0ODgwIDc1NyA3NjU0MQoyODQ0MSA3NzA1IDQyNzYKNzgwMzcgNjY3IDYxOTYzCjM0Mzg3IDMyNSAyNTkzCjI0Nzc0IDUzIDIzODM3CjU4ODAzIDQzMSA4MjcwCjc0Mjg0IDYwOSA2NzYwCjExODg0IDUxIDY0OTkKMjQ3NjkgNyAxMzEzOAo3NzIzIDcyIDkxNwozNjkxOSAyNjIgMzY0MzEKNTU0ODAgNDk2IDE4MDU0CjgzMjE4IDU3MiAyNzAKMTE4OTYgMTA2IDgwNjEKOTI4NjggMTE5IDYxNjMwCjY3MDI5IDQyNDA2IDY1NDgyCjE2MTUxIDU2NTkgMTM2MTkKNTQzMDUgMzk1IDE3MjcxCjc0MDU0IDcyOTIwIDY1NTQ1CjQ1NzUzIDE5NiAyODU1MQo0MTQ1IDMwMTkgMjYwNwo4MDAyNiA4IDQzNTQwCjQyMzQyIDE3NiAxMzI4Ngo4MjgxIDIzIDU1MTgKOTQ1MTYgMzQxIDQ4NDYzCjM2Njc1IDg5IDEwNzM2Cjg4MTA5IDMxMDM4IDEzOTA1CjQ1MjIyIDIzMjM4IDU5MzMKNzg5MDAgNjYyOTIgNDUzMDIKNjk3MCA2NyAyNDIyCjc1ODUwIDcyOTE4IDY5NTYzCjg4MzMgODggODIyMAo4OTA1NCA1MDM0MSAxMjY5OQoyNjk5NiAxNDIgNzAwMQoyMTc3NCA3MyAxMzU5NAo5NTEzMSAyMzUgOTQ5NTYKMTc0ODkgMTU0IDEzMDE1CjgzMDM2IDYyNSA0MTg1MQo5MjI1NiAzMzMwNCA3ODM0NQo2ODc0MCA2OCAzNDEwOQo1Njc0MSA0NDQ2NCA0NDkzNwo3NjUyNyA0MDYgMjQ5NTYKNDAzMTIgMTUwIDM0NTk2CjY5NDIyIDM5IDM4MDkzCjY4NDU2IDQ2OTQ4IDUwMjY4Cjk5OTE5IDk1OSA1OTA0MQoyMjQyNCAxNzEgMTUzOTEKODUxNTYgNTE2IDUxNDAKNDQzMiAzMCA0MDUzCjI0OTcgMTYwNCAxOTI1CjYyNzA4IDYwMSA3MjY4CjU1MjM4IDgzNDMgODYwMgoxODc4NiAzNCAxNjAyMwo0ODA4NiA4MyAyMjAxOAozNzczOSAxNDMgMjI1MzEKMTc0MjUgNSA5NDcxCjgyNzUgMzAgMTAyMwo2ODI2MyAyOCA1Njk4MAo2MjgwNSA4MjAzIDQ3MDE1CjYyMTQ1IDIyNCA4ODE0CjU4NzE0IDQxNiAxNzMzMwo5ODA0MyA0NTcgOTE4NTgKOTc2MDUgODA3IDI4MzA2CjE4NTcxIDE1NCAxNjg2NAo3MjMzMyA2MzggMTI4MTQKNDI1MDEgMzY3IDE1NTU3CjEzMTg1IDM4NjkgMTEyMDUKNTcyMzUgNDA4NjcgMTEzNzQKNjIyNjkgMzAzOTYgMzc0ODkKNDAwODcgMzg2IDMyNzY2Cjc1NDMgNDQgNDQ1NAo4MDk3MyA3MTEgNDU5ODgKMjY4NDkgMjU3IDE5NzA1CjU3Mzk3IDE2NSAxNjA1NAo1MjY2MiAxNzIgMjI1MzkKMzYxNDEgMTUyIDI1NTE1Cjk2MzMzIDE2MyA5MTc4NQo1MzI3IDM0IDUwODAKMTUyOCAxMzEgMTMwOAoyMjExOCAxMSA4MTEyCjMwMjg1IDUyIDE4NjE3CjIyMDk0IDQxMDQgNDExOAo5ODQ0NiA3NiA3MzA2OQo2NzEwNyAxODQyOSA1NjA5MQoxOTMyNSAxNzUgMTQxNTYKNTEwOTAgMzQzIDEzNjY2CjU0MjU5IDM5MDMwIDQ0ODYwCjUzMzI4IDM5OTU5IDQ4MTAzCjMzNTMzIDI0NSAxNjA2NAo1MDIwNCAyNjEgMzY5OTcKNDU4NiAxNCA5OAo2MzU0OCAyNzcgMjY5MjIKNzg3MTEgNTE0IDYzMzM4",
        "createdDt": "2022-12-23T18:21:38.247+00:00",
        "lastActivityDt": null,
        "imageType": "jpeg"
    },
    "status": 200
}

Description of each attribute
image: a byte array of the image that is attached this byte array cannot exceed a length of 4000
image type: describes the type of image attached jpeg, png and others
code: unique code of that particular drug.

5. Create Request for Delivery
    This api is to create a request for the drone to deliver this request adds the various medication to the cart of a particular drone.
    
    Request type: POST
    Url: {BASE_URL}\api\drone\load\drone
    Request Body: {
    "availableDroneCode": "22122022-ee099ed8-0597-4bd6-8f0b-e160f982c14e", 
    "destination": "California",
    "distance": 12.56,
    "medsToBeLoaded": [
        {
            "medicationCode": "123-ADB-MED-OFA",
            "quantity": 2
        },
        {
            "medicationCode": "123-ADD-MED-OFAQ",
            "quantity": 1
        }
    ]
}

Response: {
    "message": "Successful",
    "success": true,
    "data": {
        "droneCode": "22122022-ee099ed8-0597-4bd6-8f0b-e160f982c14e",
        "destination": "California",
        "tripId": "d1d6943e-0994-4ab6-9beb-f9a1cd2ba715",
        "totalWeight": 15.0,
        "medsToBeLoaded": [
            {
                "quantity": 2,
                "medicationCode": "123-ADB-MED-OFA"
            },
            {
                "quantity": 1,
                "medicationCode": "123-ADD-MED-OFAQ"
            }
        ]
    },
    "status": 200
}

Description of the various field
availableDroneCode: this is the serial number of the drone that has a status of IDLE.
destination: this describes the coordinate where the drone is to make the delivery.
distance: the distance from the start to destination point.
medsToBeLoaded: an array of the medication to be delivered.
medicationCode: this is the unique code for each drug.
quantity: the amount of each drug to be loaded.

6. Update Drone Status to the next stated level
  This api is to update the drone status to the next status in this sequence (LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).
  
  Request Type: PUT
  Request Body: {
    "serialNumber": "22122022-ee099ed8-0597-4bd6-8f0b-e160f982c14e",
    "status": "LOADED"
}
  Response: {
    "message": "Successful",
    "success": true,
    "data": {
        "id": 2,
        "serialNumber": "22122022-ee099ed8-0597-4bd6-8f0b-e160f982c14e",
        "model": "Lightweight",
        "weight": 20.0,
        "status": "LOADED",
        "batteryCapacity": 100.0,
        "createdDt": "2022-12-23T18:49:24.085+00:00",
        "lastActivityDt": "2022-12-23T18:49:35.802+00:00"
    },
    "status": 200
}

Description of each attribute
serialNumber: Drone serial number 
status: the next status to be updated to.

7. Get Loaded Drone Trips and details
  Request Type: GET
  Request Param: serialNumber
  Response: {
    "message": "Successful",
    "success": true,
    "data": [
        {
            "id": 1,
            "createdDt": "2022-12-23T18:49:30.836+00:00",
            "medication": {
                "id": 3,
                "name": "MEDBUFEN",
                "weight": 5.0,
                "code": "123-ADB-MED-OFA",
                "image": "MjAwCjE2ODA5IDEyMyAxMTY2OAoyMDM3MyAxODIxMSAxMDE4OAo5MjUxMiA0MTMgMzMwNDAKMjMzOSA0IDEzMzcKOTY3NDEgOTQ1IDc3MTk0CjUzMjcwIDE4MiAzMDIzOAo0NzczMyAyMzAgNDg0MAo2MDc1MSAzNDYgMjA1NzgKMTkxNTAgOTkgMjk0NQo5NDU2NiA1MTQgNDc1ODMKMTcyNzQgNTIzNCAxMjg4NQozOTQ3OCAzNjQgMjM5OTEKNDYwNTIgMzg4IDQzMDI4CjIxODE2IDE0NjQ1IDE4MjcKOTg1NzMgNzQxMjAgNDQ0MzcKNDcxNTEgNzggMjg1MjYKMTg5OTEgNzggMTAwMTAKMjg1ODMgMTEzIDUyOTkKMzQ1ODcgODYgMzMzMzQKNTkyNzIgMjQ5NDYgNDQ0MTYKNDE4OTQgMzYgNjQwCjY1MTY0IDUyMiAyMzcyOAo0MDkxNiAzOTkgMzA2NzAKNzA0NSAyNSA2NDg0CjQ1NTY3IDYzIDc1NjQKNjMwNDEgMzAyIDUwODcwCjE0NDQwIDMgMjc1CjMzNzczIDEzMTc5IDY5MjkKNzE2NTYgMzI1IDUyMzc1CjE1NzUgMSAyNjIKMjIxNiA4IDM1CjE2OTc0IDEyNDggNjA5MAo3NDg5MiAzMTQgNDgzNDAKNDUzMTIgODQ4IDQ0MTk4Cjk2NDI4IDgxMTQ0IDQzMDY2CjYxMjY0IDk2IDE0MzAwCjUyNzM0IDQ4OSA0MDc0OQo0Mjc1MSAxMjUgODg1MAo1MTgwMyAyNSAzODI1MwoxNTAxMiA2ODA2IDIzNjAKNDE0NDcgOTQgODk0NgozNTg0OSAzNDMgMjg5MTAKMzI3MTUgMTIzIDIxNTc4CjQzMzQ0IDQyNSA3OTQ5CjQxOTg2IDEwNCAxODI2OQo0ODkzIDM3IDkyMQoxMzI0MyAxMDggMTA4NDUKNDU5OTYgMjQxNTMgMzgwODAKNDg2MzAgMzY2IDQ4Mzg4CjY2NDc0IDU2MCA1MDQ4OAo5MDA0MSA2MTMgOTg3OAo1OTc1IDMyIDQwNTkKMjQ4OTIgMTU3IDM3ODMKODUyNzYgNTc5IDQxNjMKNTEwMDUgNTAzIDQ0NDE1CjU2MzY0IDQwNjY4IDUzNDQ5Cjc4MDg5IDU2NiA3MDgwNQo0NDg0MyAyOSA0NDgzOAozMTc3NyAxMjUzOCAxMTAzCjU2MDM3IDU0NSAyNDc0MwozNDYxMiAxMTYgMjE1NjkKNzg4MDYgNTkxIDY0MTg1Cjc2NzkwIDY2MSA0NDcwNAo3NzQxNyA1MiAzNTY1OQo1OTg2MSAyMTkgMzg4NTYKMTA2NDUgOTQgMTA2MjIKNDMzOCAzOSAyNTU2Cjc4NDc5IDUxMyA1OTk0MwoxMjU3NCAxMTMwMyA2NjUwCjIzMzMzIDE1MTc4IDE2NDQ0CjQ2MTQzIDE5OTk0IDI0ODc5Cjc3NDcgNTkgMzU4Nwo3MjI4NiAzMzQgNjk5MDYKOTk3NzAgNzU4IDY5ODA2Cjg1NDg2IDMzMSA0NzE1Mwo4NTAwNiA3ODE1MyAzMDM1OAo2NjE0IDM4ODcgNTc1Mwo5ODA0NiAzMzEgNjg2MDAKMjc0NTQgMjQzMzUgMTc3OTgKOTA0MzAgMTQgMzcwMDQKOTIyODUgOSA1NjM0MQoyNjYyOCAyMDkgNDMzNQo4NzE1OCA1NDAyNCA4NzIxCjczMTkgNTQzMiA2OTQwCjgzMjUzIDMxMDU1IDc2NjAxCjU5OTA4IDU1NiAyMzUyMgo1MjU4NyAyNzcgNTA2MzAKNTE5NDIgMjM0IDI3MzUzCjM4MjI0IDk2MDMgMjIyOTMKMzk3NDkgMzI2IDM4NzU3Cjk0MzcyIDMyNiA0NDU0NAozMTE0OSAyOTIgNDczNQo2MDY5NSAzNDcgMjgzNTUKMjkyOTcgOTEgMTU0NDUKNjA2MDggNTQzIDE3Njg5CjIyMjY4IDI4IDc5NTQKNzYyOCA1NiA1MDc4CjE3NDA0IDk4ODIgMzY0NgoyNjM3NyAxMTk4MSAxMzg0OAo2MDIxNyAxNDQgMjQKNDE4MzUgODkgMzQ5OTkKNzc4NzkgMTc5IDMxMDgyCjY3NzYgNTEgNTQ3Mwo2NDQxOCAxMjcgNTQxODcKODg3NDggODI1IDI1NDM3CjY5MzMyIDI5IDIxNjg3CjM4NjU0IDM3ODA5IDI3NzUyCjg0ODgwIDc1NyA3NjU0MQoyODQ0MSA3NzA1IDQyNzYKNzgwMzcgNjY3IDYxOTYzCjM0Mzg3IDMyNSAyNTkzCjI0Nzc0IDUzIDIzODM3CjU4ODAzIDQzMSA4MjcwCjc0Mjg0IDYwOSA2NzYwCjExODg0IDUxIDY0OTkKMjQ3NjkgNyAxMzEzOAo3NzIzIDcyIDkxNwozNjkxOSAyNjIgMzY0MzEKNTU0ODAgNDk2IDE4MDU0CjgzMjE4IDU3MiAyNzAKMTE4OTYgMTA2IDgwNjEKOTI4NjggMTE5IDYxNjMwCjY3MDI5IDQyNDA2IDY1NDgyCjE2MTUxIDU2NTkgMTM2MTkKNTQzMDUgMzk1IDE3MjcxCjc0MDU0IDcyOTIwIDY1NTQ1CjQ1NzUzIDE5NiAyODU1MQo0MTQ1IDMwMTkgMjYwNwo4MDAyNiA4IDQzNTQwCjQyMzQyIDE3NiAxMzI4Ngo4MjgxIDIzIDU1MTgKOTQ1MTYgMzQxIDQ4NDYzCjM2Njc1IDg5IDEwNzM2Cjg4MTA5IDMxMDM4IDEzOTA1CjQ1MjIyIDIzMjM4IDU5MzMKNzg5MDAgNjYyOTIgNDUzMDIKNjk3MCA2NyAyNDIyCjc1ODUwIDcyOTE4IDY5NTYzCjg4MzMgODggODIyMAo4OTA1NCA1MDM0MSAxMjY5OQoyNjk5NiAxNDIgNzAwMQoyMTc3NCA3MyAxMzU5NAo5NTEzMSAyMzUgOTQ5NTYKMTc0ODkgMTU0IDEzMDE1CjgzMDM2IDYyNSA0MTg1MQo5MjI1NiAzMzMwNCA3ODM0NQo2ODc0MCA2OCAzNDEwOQo1Njc0MSA0NDQ2NCA0NDkzNwo3NjUyNyA0MDYgMjQ5NTYKNDAzMTIgMTUwIDM0NTk2CjY5NDIyIDM5IDM4MDkzCjY4NDU2IDQ2OTQ4IDUwMjY4Cjk5OTE5IDk1OSA1OTA0MQoyMjQyNCAxNzEgMTUzOTEKODUxNTYgNTE2IDUxNDAKNDQzMiAzMCA0MDUzCjI0OTcgMTYwNCAxOTI1CjYyNzA4IDYwMSA3MjY4CjU1MjM4IDgzNDMgODYwMgoxODc4NiAzNCAxNjAyMwo0ODA4NiA4MyAyMjAxOAozNzczOSAxNDMgMjI1MzEKMTc0MjUgNSA5NDcxCjgyNzUgMzAgMTAyMwo2ODI2MyAyOCA1Njk4MAo2MjgwNSA4MjAzIDQ3MDE1CjYyMTQ1IDIyNCA4ODE0CjU4NzE0IDQxNiAxNzMzMwo5ODA0MyA0NTcgOTE4NTgKOTc2MDUgODA3IDI4MzA2CjE4NTcxIDE1NCAxNjg2NAo3MjMzMyA2MzggMTI4MTQKNDI1MDEgMzY3IDE1NTU3CjEzMTg1IDM4NjkgMTEyMDUKNTcyMzUgNDA4NjcgMTEzNzQKNjIyNjkgMzAzOTYgMzc0ODkKNDAwODcgMzg2IDMyNzY2Cjc1NDMgNDQgNDQ1NAo4MDk3MyA3MTEgNDU5ODgKMjY4NDkgMjU3IDE5NzA1CjU3Mzk3IDE2NSAxNjA1NAo1MjY2MiAxNzIgMjI1MzkKMzYxNDEgMTUyIDI1NTE1Cjk2MzMzIDE2MyA5MTc4NQo1MzI3IDM0IDUwODAKMTUyOCAxMzEgMTMwOAoyMjExOCAxMSA4MTEyCjMwMjg1IDUyIDE4NjE3CjIyMDk0IDQxMDQgNDExOAo5ODQ0NiA3NiA3MzA2OQo2NzEwNyAxODQyOSA1NjA5MQoxOTMyNSAxNzUgMTQxNTYKNTEwOTAgMzQzIDEzNjY2CjU0MjU5IDM5MDMwIDQ0ODYwCjUzMzI4IDM5OTU5IDQ4MTAzCjMzNTMzIDI0NSAxNjA2NAo1MDIwNCAyNjEgMzY5OTcKNDU4NiAxNCA5OAo2MzU0OCAyNzcgMjY5MjIKNzg3MTEgNTE0IDYzMzM4",
                "createdDt": "2022-12-23T18:48:48.109+00:00",
                "lastActivityDt": null,
                "imageType": "jpeg"
            },
            "quantity": 2,
            "coreDroneTrip": {
                "id": 1,
                "tripId": "dfe3cafc-f0e8-4cd9-9f02-7204ef8d40bb",
                "destination": "California",
                "distance": 12,
                "createdDt": "2022-12-23T18:49:30.799+00:00",
                "droneId": 2,
                "status": "LOADED",
                "lastActivityDt": "2022-12-23T18:49:35.798+00:00"
            }
        },
        {
            "id": 2,
            "createdDt": "2022-12-23T18:49:30.847+00:00",
            "medication": {
                "id": 2,
                "name": "CHLORO",
                "weight": 5.0,
                "code": "123-ADD-MED-OFAQ",
                "image": "MjAwCjE2ODA5IDEyMyAxMTY2OAoyMDM3MyAxODIxMSAxMDE4OAo5MjUxMiA0MTMgMzMwNDAKMjMzOSA0IDEzMzcKOTY3NDEgOTQ1IDc3MTk0CjUzMjcwIDE4MiAzMDIzOAo0NzczMyAyMzAgNDg0MAo2MDc1MSAzNDYgMjA1NzgKMTkxNTAgOTkgMjk0NQo5NDU2NiA1MTQgNDc1ODMKMTcyNzQgNTIzNCAxMjg4NQozOTQ3OCAzNjQgMjM5OTEKNDYwNTIgMzg4IDQzMDI4CjIxODE2IDE0NjQ1IDE4MjcKOTg1NzMgNzQxMjAgNDQ0MzcKNDcxNTEgNzggMjg1MjYKMTg5OTEgNzggMTAwMTAKMjg1ODMgMTEzIDUyOTkKMzQ1ODcgODYgMzMzMzQKNTkyNzIgMjQ5NDYgNDQ0MTYKNDE4OTQgMzYgNjQwCjY1MTY0IDUyMiAyMzcyOAo0MDkxNiAzOTkgMzA2NzAKNzA0NSAyNSA2NDg0CjQ1NTY3IDYzIDc1NjQKNjMwNDEgMzAyIDUwODcwCjE0NDQwIDMgMjc1CjMzNzczIDEzMTc5IDY5MjkKNzE2NTYgMzI1IDUyMzc1CjE1NzUgMSAyNjIKMjIxNiA4IDM1CjE2OTc0IDEyNDggNjA5MAo3NDg5MiAzMTQgNDgzNDAKNDUzMTIgODQ4IDQ0MTk4Cjk2NDI4IDgxMTQ0IDQzMDY2CjYxMjY0IDk2IDE0MzAwCjUyNzM0IDQ4OSA0MDc0OQo0Mjc1MSAxMjUgODg1MAo1MTgwMyAyNSAzODI1MwoxNTAxMiA2ODA2IDIzNjAKNDE0NDcgOTQgODk0NgozNTg0OSAzNDMgMjg5MTAKMzI3MTUgMTIzIDIxNTc4CjQzMzQ0IDQyNSA3OTQ5CjQxOTg2IDEwNCAxODI2OQo0ODkzIDM3IDkyMQoxMzI0MyAxMDggMTA4NDUKNDU5OTYgMjQxNTMgMzgwODAKNDg2MzAgMzY2IDQ4Mzg4CjY2NDc0IDU2MCA1MDQ4OAo5MDA0MSA2MTMgOTg3OAo1OTc1IDMyIDQwNTkKMjQ4OTIgMTU3IDM3ODMKODUyNzYgNTc5IDQxNjMKNTEwMDUgNTAzIDQ0NDE1CjU2MzY0IDQwNjY4IDUzNDQ5Cjc4MDg5IDU2NiA3MDgwNQo0NDg0MyAyOSA0NDgzOAozMTc3NyAxMjUzOCAxMTAzCjU2MDM3IDU0NSAyNDc0MwozNDYxMiAxMTYgMjE1NjkKNzg4MDYgNTkxIDY0MTg1Cjc2NzkwIDY2MSA0NDcwNAo3NzQxNyA1MiAzNTY1OQo1OTg2MSAyMTkgMzg4NTYKMTA2NDUgOTQgMTA2MjIKNDMzOCAzOSAyNTU2Cjc4NDc5IDUxMyA1OTk0MwoxMjU3NCAxMTMwMyA2NjUwCjIzMzMzIDE1MTc4IDE2NDQ0CjQ2MTQzIDE5OTk0IDI0ODc5Cjc3NDcgNTkgMzU4Nwo3MjI4NiAzMzQgNjk5MDYKOTk3NzAgNzU4IDY5ODA2Cjg1NDg2IDMzMSA0NzE1Mwo4NTAwNiA3ODE1MyAzMDM1OAo2NjE0IDM4ODcgNTc1Mwo5ODA0NiAzMzEgNjg2MDAKMjc0NTQgMjQzMzUgMTc3OTgKOTA0MzAgMTQgMzcwMDQKOTIyODUgOSA1NjM0MQoyNjYyOCAyMDkgNDMzNQo4NzE1OCA1NDAyNCA4NzIxCjczMTkgNTQzMiA2OTQwCjgzMjUzIDMxMDU1IDc2NjAxCjU5OTA4IDU1NiAyMzUyMgo1MjU4NyAyNzcgNTA2MzAKNTE5NDIgMjM0IDI3MzUzCjM4MjI0IDk2MDMgMjIyOTMKMzk3NDkgMzI2IDM4NzU3Cjk0MzcyIDMyNiA0NDU0NAozMTE0OSAyOTIgNDczNQo2MDY5NSAzNDcgMjgzNTUKMjkyOTcgOTEgMTU0NDUKNjA2MDggNTQzIDE3Njg5CjIyMjY4IDI4IDc5NTQKNzYyOCA1NiA1MDc4CjE3NDA0IDk4ODIgMzY0NgoyNjM3NyAxMTk4MSAxMzg0OAo2MDIxNyAxNDQgMjQKNDE4MzUgODkgMzQ5OTkKNzc4NzkgMTc5IDMxMDgyCjY3NzYgNTEgNTQ3Mwo2NDQxOCAxMjcgNTQxODcKODg3NDggODI1IDI1NDM3CjY5MzMyIDI5IDIxNjg3CjM4NjU0IDM3ODA5IDI3NzUyCjg0ODgwIDc1NyA3NjU0MQoyODQ0MSA3NzA1IDQyNzYKNzgwMzcgNjY3IDYxOTYzCjM0Mzg3IDMyNSAyNTkzCjI0Nzc0IDUzIDIzODM3CjU4ODAzIDQzMSA4MjcwCjc0Mjg0IDYwOSA2NzYwCjExODg0IDUxIDY0OTkKMjQ3NjkgNyAxMzEzOAo3NzIzIDcyIDkxNwozNjkxOSAyNjIgMzY0MzEKNTU0ODAgNDk2IDE4MDU0CjgzMjE4IDU3MiAyNzAKMTE4OTYgMTA2IDgwNjEKOTI4NjggMTE5IDYxNjMwCjY3MDI5IDQyNDA2IDY1NDgyCjE2MTUxIDU2NTkgMTM2MTkKNTQzMDUgMzk1IDE3MjcxCjc0MDU0IDcyOTIwIDY1NTQ1CjQ1NzUzIDE5NiAyODU1MQo0MTQ1IDMwMTkgMjYwNwo4MDAyNiA4IDQzNTQwCjQyMzQyIDE3NiAxMzI4Ngo4MjgxIDIzIDU1MTgKOTQ1MTYgMzQxIDQ4NDYzCjM2Njc1IDg5IDEwNzM2Cjg4MTA5IDMxMDM4IDEzOTA1CjQ1MjIyIDIzMjM4IDU5MzMKNzg5MDAgNjYyOTIgNDUzMDIKNjk3MCA2NyAyNDIyCjc1ODUwIDcyOTE4IDY5NTYzCjg4MzMgODggODIyMAo4OTA1NCA1MDM0MSAxMjY5OQoyNjk5NiAxNDIgNzAwMQoyMTc3NCA3MyAxMzU5NAo5NTEzMSAyMzUgOTQ5NTYKMTc0ODkgMTU0IDEzMDE1CjgzMDM2IDYyNSA0MTg1MQo5MjI1NiAzMzMwNCA3ODM0NQo2ODc0MCA2OCAzNDEwOQo1Njc0MSA0NDQ2NCA0NDkzNwo3NjUyNyA0MDYgMjQ5NTYKNDAzMTIgMTUwIDM0NTk2CjY5NDIyIDM5IDM4MDkzCjY4NDU2IDQ2OTQ4IDUwMjY4Cjk5OTE5IDk1OSA1OTA0MQoyMjQyNCAxNzEgMTUzOTEKODUxNTYgNTE2IDUxNDAKNDQzMiAzMCA0MDUzCjI0OTcgMTYwNCAxOTI1CjYyNzA4IDYwMSA3MjY4CjU1MjM4IDgzNDMgODYwMgoxODc4NiAzNCAxNjAyMwo0ODA4NiA4MyAyMjAxOAozNzczOSAxNDMgMjI1MzEKMTc0MjUgNSA5NDcxCjgyNzUgMzAgMTAyMwo2ODI2MyAyOCA1Njk4MAo2MjgwNSA4MjAzIDQ3MDE1CjYyMTQ1IDIyNCA4ODE0CjU4NzE0IDQxNiAxNzMzMwo5ODA0MyA0NTcgOTE4NTgKOTc2MDUgODA3IDI4MzA2CjE4NTcxIDE1NCAxNjg2NAo3MjMzMyA2MzggMTI4MTQKNDI1MDEgMzY3IDE1NTU3CjEzMTg1IDM4NjkgMTEyMDUKNTcyMzUgNDA4NjcgMTEzNzQKNjIyNjkgMzAzOTYgMzc0ODkKNDAwODcgMzg2IDMyNzY2Cjc1NDMgNDQgNDQ1NAo4MDk3MyA3MTEgNDU5ODgKMjY4NDkgMjU3IDE5NzA1CjU3Mzk3IDE2NSAxNjA1NAo1MjY2MiAxNzIgMjI1MzkKMzYxNDEgMTUyIDI1NTE1Cjk2MzMzIDE2MyA5MTc4NQo1MzI3IDM0IDUwODAKMTUyOCAxMzEgMTMwOAoyMjExOCAxMSA4MTEyCjMwMjg1IDUyIDE4NjE3CjIyMDk0IDQxMDQgNDExOAo5ODQ0NiA3NiA3MzA2OQo2NzEwNyAxODQyOSA1NjA5MQoxOTMyNSAxNzUgMTQxNTYKNTEwOTAgMzQzIDEzNjY2CjU0MjU5IDM5MDMwIDQ0ODYwCjUzMzI4IDM5OTU5IDQ4MTAzCjMzNTMzIDI0NSAxNjA2NAo1MDIwNCAyNjEgMzY5OTcKNDU4NiAxNCA5OAo2MzU0OCAyNzcgMjY5MjIKNzg3MTEgNTE0IDYzMzM4",
                "createdDt": "2022-12-23T18:21:38.247+00:00",
                "lastActivityDt": null,
                "imageType": "jpeg"
            },
            "quantity": 1,
            "coreDroneTrip": {
                "id": 1,
                "tripId": "dfe3cafc-f0e8-4cd9-9f02-7204ef8d40bb",
                "destination": "California",
                "distance": 12,
                "createdDt": "2022-12-23T18:49:30.799+00:00",
                "droneId": 2,
                "status": "LOADED",
                "lastActivityDt": "2022-12-23T18:49:35.798+00:00"
            }
        }
    ],
    "status": 200
}

Desciption of each attribute
CoreDroneTrip: Gives details about the trip with the trip Id.
Medications: Gives the details about the medications that are loaded in the trip.

8. Check Battery Status
  this api returns the percentage of the battery capacity of the specified drone serial
  
  Request Type: GET
  Request Params: serialNumber
  Response: {
    "message": "Successful",
    "success": true,
    "data": "100.0%",
    "status": 200
}

Description of the field attribute
data describes the battery capacity.


2. Drone Scheduler
  This is a service that runs on a CRON Job it is expected to update the drones battery capacity every 5min
  
3. Repository
    This describes all the database entities
    
    Entities include
    
    CoreDrone (Full description of the drone)
    
    
    @Table(name = "Drones", uniqueConstraints = @UniqueConstraint(columnNames = {"SerialNumber"}))
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreDrone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "SerialNumber", length = 100)
    String serialNumber;
    @Column(name = "Model")
    String model;
    @Column(name = "Weight")
    Float weight;
    @Column(name="Status")
    String status;
    @Column(name = "BatteryCapacity")
    Float batteryCapacity;
    @Column(name = "CreatedDt")
    Date createdDt;
    @Column(name = "LastActivityDt")
    Date lastActivityDt;
}

CoreDroneActivity (Describing every activity done by the drone including update of status)

@Table(name = "DroneActivity")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreDroneActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "Status")
    String status;
    @Column(name = "BatteryCapacity")
    Float batteryCapacity;
    @Column(name = "CreatedDt")
    Date createdDt;
    @Column(name = "DroneSerial")
    String droneSerial;
    @Column(name = "Destination")
    String destination;
    @Column(name = "Action")
    String action;
}


CoreDroneTrip (Describing all the trips done by the drone)


@Table(name = "DroneTrip")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreDroneTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "TripId", nullable = false)
    String tripId;
    @Column(name = "Destination", nullable = false)
    String destination;
    @Column(name = "Distance", nullable = false)
    Long distance;
    @Column(name = "CreatedDt", nullable = false)
    Date createdDt;
    @Column(name = "DroneId", nullable = false)
    Long droneId;
    @Column(name = "Status", nullable = false)
    String status;
    @Column(name = "LastActivityDt")
    Date lastActivityDt;
}


CoreMedication (Describing all existing medication on the system)

@Table(name = "Medications", uniqueConstraints = @UniqueConstraint(columnNames = "Code"))
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreMedication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "Name")
    String name;
    @Column(name = "Weight")
    Float weight;
    @Column(name = "Code")
    String code;
    @Column(name = "Image", length = 4000)
    byte[] image;
    @Column(name = "CreatedDt")
    Date createdDt;
    @Column(name = "LastActivityDt")
    Date lastActivityDt;
    @Column(name = "ImageType")
    String imageType;
}

CoreMedicationDrone (describing the drone and the medication it has carried for delivery)

@Table(name = "MedicationDrone")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreMedicationDrone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "CreatedDt")
    Date createdDt;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MedicationId")
    CoreMedication medication;
    @Column(name = "Quantity", nullable = false)
    Integer quantity;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DroneTripId", referencedColumnName = "Id")
    private CoreDroneTrip coreDroneTrip;

}


