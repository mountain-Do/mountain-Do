<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="../include/account-static-head.jsp" %>
    <link rel="stylesheet" href="/assets/css/offer-writer-editor.css">
    <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
  
    <title>Mountain-Do</title>
</head>

<body>
    <%@ include file="../include/header.jsp" %>
    <h1>추천정보 글쓰기(관리자 전용)</h1>
    <form action="/offer/offer-writer-editor" method="POST" enctype="multipart/form-data">
        <textarea name="text" id="editor"></textarea>
        <input type="file" name="imageFile">
        <div class="button-wrapper">
            <button class="submit-btn" type="submit">작성하기</button>
            <button class="close-btn" type="button" onclick="goOfferMain()">취소하기</button>
        </div>
    </form>
</body>
<script>
    ClassicEditor.create(document.querySelector('#editor'), {
        language: "ko"
    }).then(editor => {
        window.editor = editor;
        console.log("전숑전숑", editor);
        
    }).catch( error => {
        console.error( error );
    });
    
    function goOfferMain() {
        window.location.href = "/offer/offer-main";
    }
</script>
</html>
