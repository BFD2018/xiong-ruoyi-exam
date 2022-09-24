import request from '@/utils/request'

// 获取所有课程
export function listCourse(){
  return request({
    url: '/exam/course/list',
    method: 'get'
  })
}

// 查询题库列表
export function listQuestion(query) {
  return request({
    url: '/exam/question/list',
    method: 'get',
    params: query
  })
}

// 查询题库详细
export function getQuestion(questionId) {
  return request({
    url: '/exam/question/' + questionId,
    method: 'get'
  })
}

// 新增题库
export function addQuestion(data) {
  return request({
    url: '/exam/question',
    method: 'post',
    data: data
  })
}

// 修改题库
export function updateQuestion(data) {
  return request({
    url: '/exam/question',
    method: 'put',
    data: data
  })
}

// 删除题库
export function delQuestion(questionId) {
  return request({
    url: '/exam/question/' + questionId,
    method: 'delete'
  })
}
