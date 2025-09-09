# GC-Board

Spring Boot 기반 마이크로서비스 게시판 시스템

## 환경 설정

### 1. 환경변수 설정

`.env.example` 파일을 참고하여 `.env` 파일을 생성하세요:

```bash
cp .env.example .env
```

`.env` 파일에서 실제 데이터베이스 정보를 설정:

```env
DB_URL=jdbc:mysql://127.0.0.1:3306/article
DB_USERNAME=your_actual_username
DB_PASSWORD=your_actual_password
```