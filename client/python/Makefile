#  Licensed to the Apache Software Foundation (ASF) under one
#  or more contributor license agreements.  See the NOTICE file
#  distributed with this work for additional information
#  regarding copyright ownership.  The ASF licenses this file
#  to you under the Apache License, Version 2.0 (the
#  "License"); you may not use this file except in compliance
#  with the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing,
#  software distributed under the License is distributed on an
#  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
#  KIND, either express or implied.  See the License for the
#  specific language governing permissions and limitations
#  under the License.

regenerate-client:
	../templates/regenerate.sh

test-integration:
	docker compose -f docker-compose.yml kill
	docker compose -f docker-compose.yml rm -f
	docker compose -f docker-compose.yml up -d
	@echo "Waiting for Polaris HTTP health check to pass..."
	@until curl -s -f http://localhost:8182/q/health > /dev/null; do \
		sleep 2; \
		echo "Still waiting for HTTP 200 from /q/health..."; \
	done
	@echo "Polaris is healthy. Starting integration tests..."
	poetry run pytest integration_tests/ ${PYTEST_ARGS}


lint:
	poetry run pre-commit run --files integration_tests/*
