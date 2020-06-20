package br.com.theoldpinkeye.retrofittests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ReposList {

  @SerializedName("total_count")
  @Expose
  private Long totalCount;
  @SerializedName("incomplete_results")
  @Expose
  private Boolean incompleteResults;
  @SerializedName("items")
  @Expose
  private List<Item> items = null;

  /**
   * No args constructor for use in serialization
   */
  public ReposList() {
  }

  /**
   * @param incompleteResults
   * @param totalCount
   * @param items
   */
  public ReposList(Long totalCount, Boolean incompleteResults, List<Item> items) {
    super();
    this.totalCount = totalCount;
    this.incompleteResults = incompleteResults;
    this.items = items;
  }

  public Long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
  }

  public Boolean getIncompleteResults() {
    return incompleteResults;
  }

  public void setIncompleteResults(Boolean incompleteResults) {
    this.incompleteResults = incompleteResults;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

}