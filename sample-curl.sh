#!/usr/bin/env bash
curl -v -k -0 -H "Content-Type: application/json" -d "{\"username\": \"hello\", \"password\": \"foo\"}" -X POST http://localhost:7005/cxf/api/example