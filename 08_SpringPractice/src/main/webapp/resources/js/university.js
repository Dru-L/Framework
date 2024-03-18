/**
 * 춘대학 자바스크립트 모듈
 *  모듈 패턴은 관련된 변수 및 함수를 캡슐화할 때 사용하는 패턴이다.(즉시 실행 함수와 클로저 활용)
 */

// let university = (() => { });  //()로 감싸면 함수가 선언되는것과 동시에 실행된다.
let university = (() => {
    let test = 'test'; //외부에서 건드리지 못하고 캡슐화 시켜줌

	//교수 조회
    function getProfessorByNo(professorNo, success){
        console.log(`Professor No : ${professorNo}`);
        $.ajax({
            type: 'get',
            url: `/practice/professors/${professorNo}`,
            dataType : 'json',
            success: (obj) => {
                console.log('success');

                if(success){
                    success(obj);
                }
            }
        });
    } // 함수가 실행되고 삭제
    
    //교수 목록 조회(학과 번호)
    function getProfessorsByDepartmentNo(departmentNo, success){
    	console.log(`Department No : ${departmentNo}`);
    	
    	$.getJSON('/practice/professors', {departmentNo})
          .done((obj) => {
             console.log('done');
             
             if(success){
                 success(obj);
             }
        });
    }
    
    // 교수 등록
    function addProfessor(professor, success){
    	console.log(professor);
    	
    	$.ajax({
			type: 'post',
			url: '/practice/professors/enroll',
			data: JSON.stringify(professor),
			dataType: 'json',
			contentType: 'application/json;charset=utf-8',
			beforeSend: (xhr) => {
				xhr.setRequestHeader(headerName, token);
			},
			success: (obj) => {
				if (success) {
					success(obj);
				}
			}
		});
    }
    
    //과목 목록 조회 (학과 번호)
    function getSubjectsByDepartmentNo(departmentNo, success){
    	console.log(`Department No : ${departmentNo}`);
    	
    	$.getJSON('/practice/subjects', {departmentNo})
          .done((obj) => {
             console.log('done');
             
             if(success){
                 success(obj);
             }
        });
    }

    return {
        getProfessorByNo: getProfessorByNo,
        getProfessorsByDepartmentNo: getProfessorsByDepartmentNo,
        addProfessor: addProfessor,
        getSubjectsByDepartmentNo : getSubjectsByDepartmentNo
    }; //실행된 객체를 리턴하여 university라는 전역변수에 담음
})();
