import { useEffect, useState } from "react"


function App() {

  const url = 'http://localhost:8080/get/testId';
  const INITIALANGLE = {
    "id": "testId",
    "xAngle": 0.0,
    "yAngle": 0.0,
    "zAngle": 0.0
}
  const [angle, setAngle] = useState(INITIALANGLE)

  const fetchApi = async () => {
    fetch(url).then(res => res.json())
    .then(json => setAngle(json));
  }

  // TODO: Hacer que se refresque cada segundo

  useEffect(() => {
    setInterval(() => {
      fetchApi()
    }, 1000)
  }, [])

  return (
    <div className="App">
      <h1>Aplicacion analizador y corrector de postura</h1>
      <p>Angulo cervical {angle.xAngle}</p>
      {angle.badCervical ? <p>Mala postura en el cervical!</p> : <p>Ok</p>}
      <p>Angulo toraxica {angle.yAngle}</p>
      {angle.badToraxica ? <p>Mala postura en la toraxica!</p> : <p>Ok</p>}
      <p>Angulo lumbar {angle.zAngle}</p>
      {angle.badLumbar ? <p>Mala postura en la lumbar!</p> : <p>Ok</p>}
    </div>
  );
}

export default App;
