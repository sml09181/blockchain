package core;

import util.Util;

public class Block {
	
	private int blockID;
	private String previousBlockHash; // 여러 개의 블록들이 블록체인 형태로 연결되어 있다는 것을 알려 줌.
	private int nonce;
	private String data; // 블록의 데이터가 문자열 형태라 가정
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Block(int blockID, String previousBlockHash, int nonce, String data) {
		super();
		this.blockID = blockID;
		this.nonce = nonce;
		this.data = data;
	}
	
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	
	// 특정한 블록 하나의 정보를 출력
	public void getInformation() {
		System.out.println("--------------------");
		System.out.println("블록 번호: " + getBlockID());
		System.out.println("이전 해시: "+ getPreviousBlockHash());
		System.out.println("채굴 변수 값: "+ getNonce());
		System.out.println("블록 데이터: " + getData());
		System.out.println("블록 해시: " + getBlockHash());
		System.out.println("--------------------");
	}
	
	// 현재 블록을 해시 데이터로 표현
	public String getBlockHash() {
		return Util.getHash(nonce + data + previousBlockHash);
	}
	
	//채굴 수행
	public void mine() {
		while (true) {
			if (getBlockHash().substring(0, 4).equals("0000")) {
				System.out.println(blockID + "번째 블록의 채굴에 성공했습니다.");
				break;
			}
			nonce++;
		}
	}
}
