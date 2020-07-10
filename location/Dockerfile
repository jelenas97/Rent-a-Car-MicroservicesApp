FROM python:3
COPY location.py ./
RUN pip install pika --upgrade
CMD sh -c "sleep 60s && python location.py"

