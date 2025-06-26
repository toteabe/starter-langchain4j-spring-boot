#https://medium.com/@giuseppetrisciuoglio/building-a-booking-chatbot-with-spring-boot-and-langchain4j-a-complete-guide-1a22b8ad6a51
#https://medium.com/@giuseppetrisciuoglio/building-rag-systems-a-complete-guide-to-langchain4j-and-deepseek-r1-e5212aefb8d4

# Pull Ollama image
docker pull ollama/ollama

# Create volume
docker volume create ollama

# Start the container
docker run -rm -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama

# Verify that the container is running
docker ps

# Connect to the container
docker exec -it ollama sh

# Download base model (7B)
ollama pull deepseek-r1

# Or download the light version (1.5B)
ollama pull deepseek-r1:1.5b

# Exit the container
exit

# Basic test to verify functionality
docker exec -it ollama ollama run deepseek-r1 "Hello, how are you?"

# Create a persistent volume
docker volume create ollama-models

# Use the volume in the container
docker run -d \
    -v ollama-models:/root/.ollama \
    -p 11434:11434 \
    --name ollama \
    ollama/ollama

# Limit container resources
docker run -d \
    -v ollama-models:/root/.ollama \
    -p 11434:11434 \
    --cpus=4 \
    --memory=8g \
    --name ollama \
    ollama/ollama

# Verify service status
curl http://localhost:11434/api/health

# View container logs
docker logs ollama

# Resource monitoring
docker stats ollama

# Volume backup script
#!/bin/bash
docker run --rm \
    -v ollama-models:/source \
    -v /backup:/backup \
    alpine tar czf /backup/ollama-models-$(date +%Y%m%d).tar.gz -C /source .
