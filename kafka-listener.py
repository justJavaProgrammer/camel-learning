from kafka import KafkaConsumer


consumer = KafkaConsumer(
    'camel-test',
    bootstrap_servers='localhost:29092',
    group_id='my_group'
)

for message in consumer:
    print(f"{message.key}: {message.value}")

    if len(message.value) > 50:
        print(message.value.decode("utf-8"))
