import { useState } from "react";

function App(){
    //{"id":101,"name":"Vasudha","course":"CSE"}
    const [students,setStudents]=useState([]);
    const [count,setCount]=useState(0);

    const getStudentData =async()=>{
        const response=await fetch('http://localhost:8080/student');
        const data= await response.json();
        setStudents(data);
    }
    const fetchTotalStudentCount= async()=>{
        const response= await fetch("https://localhost:8080/student/count");
        const data= await response.json();
        setCount(data);

    };
    return(
        <div>
            <button onClick ={getStudentData}>
                Get Student Data
            </button>
            <h1>This is the student data</h1>
            <ul>
                {students.map(student => (
                    <li key={(student.id)}>
                        {student.course}.{student.name}
                    </li>
                ))}
            </ul>
            <button onClick={fetchTotalStudentCount}> 
                Get Total Student Count
            </button>
            <p>Total students: {count}</p>
        </div>
    );
}

export default App;