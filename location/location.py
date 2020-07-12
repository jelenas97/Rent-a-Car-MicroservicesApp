import pika
import time

connection = pika.BlockingConnection(pika.ConnectionParameters('rabbitmq-broker'))
channel = connection.channel()

locations = ["45.273715, 19.848423,2", "45.277597, 19.850175, 2",  "45.281945, 19.850947, 2",  "45.285569, 19.851634,2",
             "45.290460, 19.852921,2",  "45.295351, 19.854037,2", "45.300483, 19.857471,2", "45.302113, 19.862363,2",
             "45.298684, 19.871528,2", "45.292887, 19.882171,2", "45.284675, 19.897277,2",
             "45.279776, 19.907947,2", "45.277259, 19.917751,2", "45.274462, 19.929277,2", "45.270360, 19.946499,2"
             , "45.267656, 19.958953,2", "45.265418, 19.969551,2", "45.262341, 19.983064,2", "45.258238, 19.998962,2"
             , "45.252922, 20.014198,2", "45.248631, 20.024134,2", "45.244154, 20.032613,2", "45.239692, 20.039133,2"
             , "45.233479, 20.047483,2", "45.226711, 20.055361,2", "45.220496, 20.060402,2", "45.214504, 20.064814,2"
             , "45.208399, 20.068910,2", "45.202294, 20.072061,2", "45.195300, 20.074739,2", "45.184905, 20.077573,2"
             , "45.173699, 20.079163,2", "45.160996, 20.081017,2", "45.146982, 20.084727,2", "45.133525, 20.087907,2"]

#channel.queue_declare(queue='location-queue')
while 1:
    for i in locations:
        time.sleep(5)
        channel.basic_publish(exchange='',
                              routing_key='location-queue',
                              body=i)
        print(" [x] Sent 'Hello World!'")

connection.close()