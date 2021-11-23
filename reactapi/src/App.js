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
  const [toggler, setToggler] = useState(false)

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
      <h1>Joseph App Dev</h1>
      <p>Angulo x {angle.xAngle}</p>
      <p>Angulo Y {angle.yAngle}</p>
      <p>Angulo Z {angle.zAngle}</p>
    </div>
  );
}

export default App;
