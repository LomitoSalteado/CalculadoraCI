import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 10,
  duration: '10s',
};

export default function () {
  const res = http.post('http://localhost:8080/api/dividir', JSON.stringify({ a: 100, b: 5 }), {
    headers: { 'Content-Type': 'application/json' },
  });

  check(res, {
    'status 200': (r) => r.status === 200,
    'resultado correcto': (r) => r.body.includes('20.00'),
    'latencia < 500ms': (r) => r.timings.duration < 500,
  });

  sleep(1);
}
