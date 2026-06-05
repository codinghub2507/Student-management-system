import { useState } from "react";

function App(){
    //{"id":101,"name":"Vasudha","course":"CSE"}
    const [students,setStudents]=useState({});

    const getStudentData =async()=>{
        const response=await fetch('http://localhost:8080/student');
        const data= await response.json();
        setStudents(data);
    }
    return(
        <div>
            <button onClick ={getStudentData}>
                Get Student Data
            </button>
            <h1>This is the student data</h1>
            <h2>{students.name}</h2>
            <h3>{students.course}</h3>
            <h4>{students.id}</h4>
        </div>
    );
}

export default App;